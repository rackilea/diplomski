System.out.print("Enter a number: ");
    Scanner input = new Scanner(System.in);
    int num = input.nextInt();
    int ans = 0;

    Random rand = new Random();
    int min = 0;
    int max = 100;
    int guess = rand.nextInt(max);

    while (guess != num) {
        System.out.print("Is it " + guess + " ? ");
        ans = input.nextInt();
        if (ans == 1) {
            min = guess + 1;
        } else if (ans == 2) {
            max = guess;
        }


        guess = rand.nextInt(max - min) + min;

    }
    System.out.print("Computer guessed: " + guess);