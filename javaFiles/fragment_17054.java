Scanner input = new Scanner(System.in);
    int studentNum = 0;
    ArrayList<Integer> calc = new ArrayList<Integer>();

    while (studentNum <= 100) {

        System.out.print("Enter a number: ");
        calc.add(input.nextInt());

        studentNum += 1;

        if (input.nextInt() == -99) {
            break;
        }

    }

    int min = Collections.min(calc);
    int max = Collections.max(calc);

    for (int i = 0; i < calc.size(); i++) {
        int number = calc.get(i);
        if (number < min)
            min = number;
        if (number > max)
            max = number;
    }

    System.out.println("Max is " + max);
    System.out.println("Min is " + min);