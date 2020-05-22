Scanner scan = new Scanner(System.in);  
Random numRand = new Random();

boolean keep_playing = true;

do
{
    num1 = numRand.nextInt((9 - 0) + 1);
    num2 = numRand.nextInt((9 - 0) + 1);
    num3 = numRand.nextInt((9 - 0) + 1);

    System.out.println(num1 + " " + num2  + " " + num3);

    if(num1 == num2 && num1 == num3) { // && num2 == num3  - unnecessary
        System.out.println("All three match - jackpot");
    }
    else if(num1 == num2 || num2 == num3 || num1 == num3) {
        System.out.println("Two number match");
    }
    else {
        System.out.println("No numbers match");
    }

    System.out.printf("Would you like to play again? ");

    String input = scan.nextLine();
    keep_playing = input.equals("y");

} while ( keep_playing )

scan.close();