public static void main(String[] args) {
    Scanner sc = new Scanner(
            "read 12\n"
            + "+++++++++++++\n"
            + "++++++++++#++\n"
            + "++++++++++#++\n"
            + "++++++++++#++\n"
            + "++++++++++#++\n"
            + "++++++++++#++\n"
            + "++++++++++#++\n"
            + "++++++++++#++\n"
            + "++++++++++#++\n"
            + "++++++++++#++\n"
            + "++++++++++#++\n"
            + "++++++++++#--\n"
            + "fill 2 2 d");
    String read, numberst;
    String[] image;
    int number = 0, count = 0;
    Boolean error = false;

    read = sc.next();
    numberst = sc.next();

    if ((read + numberst).matches("read[0-9]+")) {
        number = Integer.parseInt(numberst);
    } else {
        error = true;
    }

    image = new String[number];

    System.out.println("image");

    while (sc.hasNextLine() && (error == false) && (count <= number - 1)) {
        image[count] = sc.next();
        // System.out.println(image[count] + " " + count);
        count++;
        if (image[0].length() != image[count - 1].length()) {
            error = true;
            System.out.println("INPUT MISMATCH");
        }
    }

    System.out.println("fill");
    while (sc.hasNextLine() && (error == false) && sc.hasNext()) {
        String fill = "", xstr = "", ystr = "", cstr;

        fill = sc.next();

        if (sc.hasNext()) {
            xstr = sc.next();
        } else {
            error = true;
            System.out.println("INPUT MISMATCH");
        }

        if (sc.hasNext() && error == false) {
            ystr = sc.next();
        } else {
            error = true;
            System.out.println("INPUT MISMATCH");
        }

        if (sc.hasNext() && error == false) {
            cstr = sc.next();

            if ((fill + xstr + ystr + cstr).matches("fill[0-9]+[0-9]+.")) {
                int x = Integer.parseInt(xstr), y = Integer.parseInt(ystr);
                char c = cstr.charAt(0);

                if (x <= image[0].length() && y <= number) {
                    fill(image, x, y, image[y].charAt(x), c);
                } else {
                    error = true;
                    System.out.println("OPERATION FAILED");
                }
                // System.out.println(fill + x + y + c);
            } else {
                error = true;
                System.out.println("INPUT MISMATCH");
            }

        } else {
            error = true;
            System.out.println("INPUT MISMATCH");
        }
        // System.out.println(error);
    }

    if (error == false) {
        for (int i = 0; i < number; ++i) {
            System.out.println(image[i]);
        }
    }
}

public static void fill(final String[] image, final int x, final int y, final char oldValue, final char newValue) {
    if (oldValue == image[y].charAt(x)) {
        image[y] = image[y].substring(0, x) + newValue + image[y].substring(x + 1);

        if ((x + 1) < image[y].length()) {
            fill(image, x + 1, y, oldValue, newValue);
        }

        if ((x - 1) >= 0) {
            fill(image, x - 1, y, oldValue, newValue);
        }

        if ((y - 1) >= 0) {
            fill(image, x, y - 1, oldValue, newValue);
        }

        if ((y + 1) < image.length) {
            fill(image, x, y + 1, oldValue, newValue);
        }
    }
}