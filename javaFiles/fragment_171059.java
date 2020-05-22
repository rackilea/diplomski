String[][] students = { { "John", "Mark", "James" }, { "3", "2", "1" } };
    for (int i = 0; i < students[0].length; i++) {
        StringBuilder asterix = new StringBuilder();
        for (int acnt = 0; acnt < Integer.parseInt(students[1][i]); acnt++)
            asterix.append("*");
        System.out.printf("%s\t%s\t%s", students[0][i], students[1][i],asterix.toString());
        System.out.println();
    }