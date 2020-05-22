function twosInRange(number) {
    var digits = Math.floor(Math.log(number) / Math.log(10));
    var count = 0;
    for (var pos = digits; pos >= 0; --pos) {     // 3, 2, 1, 0
        var unit = Math.pow(10, pos);             // 1000, 100, 10, 1
        var digit = Math.floor(number / unit);    // 2, 4, 6, 8
        number -= digit * unit;                   // 468, 68, 8, 0
        // COUNT OCCURRENCES IN LOWER DIGITS:
        count += digit * pos * (unit / 10);       // + 2*3*100, 4*2*10, 6*1*1, 8*0*0
        // COUNT OCCURRENCES IN CURRENT DIGIT:
        if (digit > 2) count += unit;             // + (1000), 100, 10, 1
        else if (digit == 2) count += number + 1; // + 469, (69), (9), (1)
    }
    return (count);                               // 600 + 80 + 6 + 100 + 10 + 1 + 469
}

document.write(twosInRange(2468));                // = 1266