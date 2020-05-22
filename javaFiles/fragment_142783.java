int days = 11;
        int num = -10;
        int output = num + 2;
        System.out.println("Day \t Num");
        int half = days / 2;
        for (int i = 1; i <= half; i++) {
            output -= 2;
            System.out.println(i + "\t" + output);
        }
        for (int i = half + 1; i <= days; i++) {
            output++;
            System.out.println(i + "\t" + output);
        }