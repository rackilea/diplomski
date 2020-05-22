function arrayOfNums(arr){
    var numberPattern = /\d+/g;
    var  newArr = [];
    for (var i = 0; i < arr.length; i++) {
        newArr[i] = parseInt(arr[i].match( numberPattern ).join(""));
    };
    return newArr;
}