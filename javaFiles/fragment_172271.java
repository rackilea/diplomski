function ZeroOneGen(dataArr, digits, index) {
    var i, z;
    if (index == digits) {
        var str = "";
        for (i = 0; i < digits; i++) {
            str = str + dataArr[i];
        }
        console.log(str)
        return;
    }

    for (z = 0; z < 2; z++) {
        dataArr[index] = z;
        ZeroOneGen(dataArr, digits, index + 1);
    }
}

var dataArrTemp = new Array(3);
ZeroOneGen(dataArrTemp, 3, 0);