do {
    for(int i = 0; i < N; i++) //collecting the integers
    {
        System.out.print("Enter a number: ");
        newInt = keyboard.nextInt();
        if (newInt < 0) {
            System.out.println("NegativeIntegerException: N must be a positive integer");
            // Ignore this input
            i--;
            continue;
        }
        numbers[i] = newInt;
    }
    z = 2;
} while (z == 1);