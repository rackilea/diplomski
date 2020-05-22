public static String compareImage() throws Exception {

// savedImage is the image we want to look for in the new screenshot.
// Both must have the same width and height

    String c1 = "savedImage";
    String c2 = "capture";

    BufferedInputStream in = new BufferedInputStream(new FileInputStream(c1
            + ".png"));
    BufferedInputStream in1 = new BufferedInputStream(new FileInputStream(
            c2 + ".png"));
    int i, j;
    int k = 1;
    while (((i = in.read()) != -1) && ((j = in1.read()) != -1)) {
        if (i != j) {
            k = 0;
            break;
        }
    }

    in.close();
    in1.close();
    if (k == 1) {

        System.out.println("Ok...");
        return "Ok";            

    } else {
        System.out.println("Fail ...");
        return "Fail";
    }
}