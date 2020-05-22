DataSet d1 = new DataSet();
    do {
        System.out.println("Do you want to enter another number?");
        answer = scan.next();
        if (answer.equalsIgnoreCase("YES")) {
            double sum, number;
            d1.run();
            number = d1.getaddValueToSet();
            sum = d1.getSum();
            answer = scan.nextLine();
            System.out.println(d1);
        } else {
            break;
        }
    } while (true);