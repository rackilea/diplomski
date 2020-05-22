function escapeForRegex(str){
    return String(str).replace(/[.*+?^=!:${}()|[\]\/\\]/g, '\\$&');
}

//dynamically build my parsing regex:
var tokenParser = new RegExp([
        //numbers
        /\d+(?:\.\d*)?|\.\d+/.source,

        //string-literal
        //  /["](?:\\[\s\S]|[^"])+["]|['](?:\\[\s\S]|[^'])+[']/.source,

        //booleans
        //"true|false",

        //operators
        [".", "(", ")"].concat(UnaryNode.operators, BinaryNode.operators)
            .sort((a,b) => b.length-a.length) //so that ">=" is added before "=" and ">", for example
            .map(escapeForRegex)
            .join("|"),

        //properties
        //has to be after the operators
        /[a-zA-Z$_][a-zA-Z0-9$_]*/.source,

        //remaining (non-whitespace-)chars, just in case
        //has to be at the end
        /\S/.source
    ].map(s => "("+ s +")").join("|"), "g");

function parse(str){
    var tokens = [];
    //abusing str.replace() as a RegExp.forEach
    str.replace(tokenParser, function(token, number, op, property){
        if(number){
            token = new ValueNode(+number);
        //}else if(string){
        //  token = new ValueNode(JSON.parse(string));      
        //}else if(bool){
        //  token = new ValueNode(bool === "true");
        }else if(property){
            token = new PropertyNode(property);
        }else if(!op){
            throw new Error("unexpected token '"+token+"'");
        }
        tokens.push(token);
    });

    for(var i; (i=tokens.indexOf(".")) > -1; ){
        tokens.splice(i-1, 3, new DotNode(tokens[i-1], tokens[i+1]))
    }

    for(var i,j; (i=tokens.lastIndexOf("(")) > -1 && (j=tokens.indexOf(")", i)) > -1;){
        tokens.splice(i, j+1-i, process(tokens.slice(i+1, j)));
    }
    if(~tokens.indexOf("(") || ~tokens.indexOf(")")){
        throw new Error("mismatching brackets");
    }

    return process(tokens);
}

function process(tokens){
    UnaryNode.operators.forEach(token => {
        for(var i=-i; (i=tokens.indexOf(token, i+1)) > -1;){
            tokens.splice(i, 2, new UnaryNode(token, tokens[i+1]));
        }
    })

    BinaryNode.operators.forEach(token => {
        for(var i=1; (i=tokens.indexOf(token, i-1)) > -1;){
            tokens.splice(i-1, 3, new BinaryNode(token, tokens[i-1], tokens[i+1]));
        }
    });

    if(tokens.length !== 1){
        console.log("error: ", tokens.slice());
        throw new Error("something went wrong");
    }
    return tokens[0];
}