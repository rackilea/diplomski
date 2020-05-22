float cer = 0;
float big = 0;

void draw() {

    // [...]

    cer = cer + big;

    println(cer, big);
    if (cer < width) {
        big += 1;
    } else {
        background(255);
        cer = 0;
        big = 0;
    }

    // [...]

}