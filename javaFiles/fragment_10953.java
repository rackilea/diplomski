while(true) {
    float newF = f + 1.0f;
    if(newF == f) System.out.println(newF);
    f += 1.0f;
    if (f >= number) {
        System.out.println(f);
        System.out.println(number + " took " + (System.currentTimeMillis() - startTime) + " msecs");
        break;
    }
}