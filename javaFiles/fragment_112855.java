if (i<4) {
    //2015 index  0,1,2,3
    year[i] = release[i];
} else if (i>4 && i<7) {
    //04 index  5,6
    month[i-5] = release[i];
} else if (i>7 && i<10) {
    //10 index 8,9
    date[i-8] = release[i];
}