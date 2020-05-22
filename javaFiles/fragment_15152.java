int lineLength = 8;

    for (int i = 0; i <= 5; ++i) {

        //print number
        StringBuilder sb = new StringBuilder();
        for (int j = i; j >= 0; j--) {
            sb.append((int) Math.pow(2, j));
        }

        //print space
        for (int spaces = lineLength - sb.length(); spaces > 0; spaces--) {
            System.out.print(" ");
        }
        System.out.println(sb.toString());
    }