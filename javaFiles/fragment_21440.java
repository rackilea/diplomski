for (int i = 0; i < pole.length; i++) {
    if (pole[i] > 0) {
        pklad[jpos++] = pole[i];

    } else if (pole[i] < 0) { 
        pzap[jneg++] = pole[i];

    } else {
        n[jn++]=pole[i];
    }
}