if (s*2 >= j && t >= s) { // 2 * 2 >= 3 && 5 >= 2 - true
        if (s>j) { // 2 > 3 - false
            s++; // not executed
        }
        t = t * s; // executed
    } else {
        t += s; // not executed
    }
    t++; // executed