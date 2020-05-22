for (int num1 = 0; num1 < rolls; num1 = num1 + 1);
    {
        Console.out.println("Roll No. " + num1);
        num = generator.nextInt(sides);
        System.out.println("You rolled a " + num);
    }