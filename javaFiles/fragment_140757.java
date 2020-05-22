function countHeavy(A, B, weight) {
    var a = decimalDigits(A), b = decimalDigits(B);        // create arrays
    while (a.length < b.length) a.push(0);                 // add leading zeros
    var digits = b.length, table = weightTable();          // create table
    var count = 0, diff = B - A + 1, d = 0;                // calculate range
    for (var i = digits - 1; i >= 0; i--) if (a[i]) d = i; // lowest non-0 digit
    while (diff) {                                         // increment a until a=b
        while (a[d] == 10) {                               // move to higher digit
            a[d++] = 0;
            ++a[d];                                        // carry 1
        }
        var step = Math.pow(10, d);                        // value of digit d
        if (step <= diff) {
            diff -= step;
            count += increment(d);                         // increment digit d
        }
        else --d;                                          // move to lower digit
    }
    return count;

    function weightTable() {                               // see above for details
        var t = [[],[9,8,7,6,5,4,3,2,1,0]];
        for (var i = 2; i < digits; i++) {
            var total = Math.pow(10, i), final = total / 10;
            t[i] = [];
            for (var j = 9 * i; total > 0; --j) {
                if (j > 9) total -= t[i - 1][j - 10]; else total -= final;
                if (j < 9 * (i - 1)) total += t[i - 1][j];
                t[i].push(total);
            }
        }
        return t;
    }
    function increment(d) {
        var sum = 0, size = digits;
        for (var i = digits - 1; i >= d; i--) {
            if (a[i] == 0 && i == size - 1) size = i;      // count used digits
            sum += a[i];                                   // sum of digits
        }
        ++a[d];
        var target = weight * size - sum;
        if (d == 0) return (target < 0) ? 1 : 0;           // if d is lowest digit
        if (target < 0) return table[d][0] + 1;            // whole range is heavy
        return (target > 9 * d) ? 0 : table[d][target];    // use look-up table
    }
    function decimalDigits(n) {
        var array = [];
        do {array.push(n % 10);
            n = Math.floor(n / 10);
        } while (n);
        return array;
    }
}
document.write("0 &rarr; 100,000,000 = " + countHeavy(0, 100000000, 7) + "<br>");
document.write("782 &rarr; 4321 = " + countHeavy(782, 4321, 7) + "<br>");
document.write("782 &rarr; 4321 = " + countHeavy(782, 4321, 5) + " (weight: 5)");