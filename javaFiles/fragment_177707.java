public static int combineBrighter(Color c1, Color c2) {
    int r = c1.getRed();
    int g = c1.getGreen();
    int b = c1.getBlue();

    int rr = c2.getRed();
    int gg = c2.getGreen();
    int bb = c2.getBlue();

    int rrr;               // declare them in this scope
    int ggg;
    int bbb;

    if(r >= rr){
      rrr = r;             // assign values later
    } else {
       rrr = rr;
    }

    ...

    Color f = new Color(rrr, ggg, bbb);
    return f;