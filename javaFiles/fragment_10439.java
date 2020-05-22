if (choice.equals("a") || choice.equals("A")) {
        System.out.println(name + " You have chosen Addition");
        System.out.println("Type the first number:");
        fnum = Double.parseDouble(input.nextLine());
        System.out.println("Type the second number:");
        snum = Double.parseDouble(input.nextLine());
        System.out.println("your answer is:");
        Addition addy = new Addition(fnum, snum);
        System.out.println(addy.getans());
    }