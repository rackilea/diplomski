//abstract base-class
class GraphNode {
    constructor(){
        Object.defineProperty(this, "parent", {
            writable: true,
            //enumerable: false,    //so it doesn't show up in JSON
            value: null
        })
    }
    compute(ctx){ throw new Error("not implemented") }
    toString(){ throw new Error("not implemented") }
}

//leaf-nodes
class ValueNode extends GraphNode{
    constructor(value){ 
        super();
        this.value = value; 
    }
    compute(){ return this.value; }
    toString(){ return JSON.stringify(this.value); }
}

class PropertyNode extends GraphNode{
    constructor(property){
        super();
        this.property = property;
    }
    compute(ctx){ return ctx[this.property]; }
    toString(){ return String(this.property); }
}

//tree-nodes
class UnaryNode extends GraphNode{
    constructor(op, node){
        if(!(node instanceof GraphNode)){
            throw new Error("invalid node passed")
        }
        super();
        this.op = op;
        this.node = node;
        node.parent = this;
    }
    compute(ctx){
        var v = this.node.compute(ctx);
        switch(this.op){
            case "NOT": return !v;
        }
        throw new Error("operator not implemented '"+this.op+"'");
    }
    toString(){
        return  "( " + this.op + " " + this.node.toString() + " )";
    }   
}
UnaryNode.operators = ["NOT"];


class BinaryNode extends GraphNode{
    constructor(op, l, r){
        if(!(l instanceof GraphNode && r instanceof GraphNode)){
            throw new Error("invalid node passed")
        }
        super();
        this.op = op;
        this.left = l;
        this.right = r;
        l.parent = this;
        r.parent = this;
    }
    compute(ctx){
        var l = this.left.compute(ctx);
        var r = this.right.compute(ctx);
        switch(this.op){
            //logic operators
            case "AND": return l && r;
            case "OR": return l || r;

            //comparison-operators
            case "=": return l === r;
            case "<=": return l <= r;
            case ">=": return l >= r;
            case "!=": return l != r;
            case ">": return l > r;
            case "<": return l < r;

            //computational operators
            case "+": return l + r;
            case "-": return l - r;
            case "*": return l * r;
            case "/": return l / r;
        }
        throw new Error("operator not implemented '"+this.op+"'");
    }

    toString(){
        return "( " + this.left.toString() + " " + this.op + " " + this.right.toString() + " )";
    }
}
//also defines precendence
BinaryNode.operators = [
    "*","/","+","-",
    ">","<","<=",">=","!=","=",
    "AND","OR",
]

//dot is kind of special:
class DotNode extends BinaryNode{
    constructor(l, r){
        /*
        if(!(l instanceof PropertyNode || l instanceof DotNode)){
            throw new Error("invalid left node")
        }
        */
        if(!(r instanceof PropertyNode)){
            throw new Error("invalid right node")
        }
        super(".", l, r);
    }

    compute(ctx){
        //especially because of this composition:
        //fetch the right property in the context of the left result
        return this.right.compute( this.left.compute(ctx) );
    }
    toString(){
        return this.left.toString() + "." + this.right.toString();
    }
}