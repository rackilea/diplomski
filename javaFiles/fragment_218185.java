Scanner scanner = new Scanner(System.in);
    while (again == 2) {
        ano = 0;

        System.out.print("\n enter NAME: ");
        aname = scanner.nextLine();

        while (ano < 1 || ano > 20) {
            System.out.print("\n enter number 1-20: ");
            ano = scanner.nextInt();
        }

        seeit(msg, aname, ano);

        System.out.print("\n do you want to do this again? 2 for yes ");
        again = scanner.nextInt();
    }