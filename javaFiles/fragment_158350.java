document.write = function(){
    document.getElementById("MyDiv").innerHTML = arguments[0];
}

function getTreeStruct() {
new Ajax.Request('MainServlet', {
    method: 'POST',
    parameters: "action=getTreeStruct",
    onSuccess: function(transport) {

        d = new dTree('d');
        d.add(0, -1, 'Root Element');
        //contains data queried from database to be inserted into the tree.
        var responseArray = transport.responseText.split("|");
        //Add each element to the tree object
        iterate1DArray(function(x) {
            var tempArray = x.split(",");
            if(tempArray[1] != undefined
                    && !(tempArray[0] == 0 && tempArray[1] ==0)){
                d.add(tempArray[0], tempArray[1], tempArray[2]);
            }
        }, responseArray);

        document.write(d);

    }
});

}

function iterate1DArray(func, array) {
    for( var i = 0; i < array.length; i++){
        array[i] = func(array[i]);
    }
}