q = 0;
for(int i = 32; i > 0; i -= 1){
    q <<= 1;
    p = (2 * p) - den;

    if(p >= 0){
        q += 1;
    } else {
        // implicit: q += 0
        p += den;
    }
}