public static char getInput(String prompt, char[] options, Scanner sc) {
        // getInput method
        // prompts user for an input that matches one of the given characters
        // if its not one of those, repeat. (use contains (above))
        char c;
        boolean flag = false;
        String printStr = prompt + " (";
        for (int i = 0; i < options.length; i++) {
            printStr += " " + options[i] + ",";
        }
        printStr = printStr.substring(0, printStr.length() - 1) + " ):\\n";

        do {
            c = sc.next().charAt(0);
            System.out.println(printStr);
            if (contains(c, options)) {
                flag = true;
            }
        }
        while (!flag);
        return c;
    }