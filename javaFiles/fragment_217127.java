//positive slope diagonal
if(((i - Math.min(i, l)) + k) < 8 && ((l - Math.min(i, l)) + k) < 8)
    testArray[(i - Math.min(i, l)) + k][(l - Math.min(i, l)) + k] = true;

//negative slope diagonal
if((k) < 8 && ((l + i) - k) >= 0 && ((l + i) - k) < 8)
    testArray[k][(l + i) - k] = true;