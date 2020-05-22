function makeObject(keys, array) {
    var output = [];
    for (var o = 0; o < array.length; o++) {
        var object = {};
        for (var i = 0; i < array[o].length; i ++ ) {
         object[keys[i]] = array[o][i];
        }
        output.push(object);
    }
    return output;
}

// input array
var array = [["title","details"],["abc","xyz"],["abc2","xyz2"]];    

// extract keys leaving only values in array
var keys = array.shift();

// build object
var output = makeObject(keys, array);