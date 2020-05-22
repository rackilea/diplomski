int sum = 0;
    int i = 0;
    ArrayList nummer = new ArrayList(); // make new list
           Scanner input = new Scanner(System.in); // start scanner
    while (true) {
        System.out.print("Voer uw naam in: ");

        String naam = input.nextLine(); // scanner waiting for input + enter
        if (naam.equals("0")) {
            System.out.println("Wrong, exit!");
            input.close();

             for (Object item : nummer) { // foreach-loop
                 System.out.print(item + "\n");
                 i = Integer.parseInt((String) item);
                                     sum += i;
                     }
             System.out.println(sum);
            break;
        } else { 
            nummer.add(naam);
        }
    }