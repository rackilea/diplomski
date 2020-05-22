final Scanner console = new Scanner(System.in);
    final List<Integer> input = new ArrayList<Integer>();

    while (true)
    {
        System.out.print("Please enter an integer : ");

        if (console.hasNextInt())
        {
            input.add(console.nextInt());
        }
        else
        {
            System.out.println("Bad input, try again ...");
            console.next();
        }
        if (input.size() >= 2)
        {
            break;
        }
    }

    System.out.println("\n");
    System.out.println("First integer entered was : " + input.get(0));
    System.out.println("Second integer entered was : " + input.get(1));