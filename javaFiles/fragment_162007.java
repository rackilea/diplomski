void draw() {

    // [...]

    cer = cer + big;

    if (cer < width) {
        big = +1;
    } else {
        // clear background
        background(255);

        // reset to initial state 
        cer = 0;
        big = 14;
    }

    // [...]
}