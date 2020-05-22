Scanner input = new Scanner(System.in);
        // Prompt the user to enter an integer
        System.out.print("Please enter an integer number:");
        int int1 = input.nextInt();

// Prompt the user to enter a character
// Since I could not use characters, I am using integers to represent them.
        System.out.print("Enter +, -,  /,  %, *");
        char char1 = input.next().charAt(0);

// Prompt the user to enter another integer
        System.out.print("Please enter another integer number:");
        int int2 = input.nextInt();

        if (char1=='+') {
            int ans = int1 + int2;
            System.out.println(int1 + " + " + int2 + " = " + ans);
        } else if (char1=='-') {
            int ans = int1 - int2;
            System.out.println(int1 + " - " + int2 + " = " + ans);
        } else if (char1=='/') {
            int ans = int1 / int2;
            System.out.println(int1 + " / " + int2 + " = " + ans);
        } else if (char1=='%') {
            int ans = int1 % int2;
            System.out.println(int1 + " % " + int2 + " = " + ans);
        } else if (char1=='*') {
            int ans = int1 * int2;
            System.out.println(int1 + " * " + int2 + " = " + ans);
        } else {
            System.out.println("Invalid operator");
        }

        int result = 0;

        switch (char1) {
            case '+':
                result = int1 + int2;
                System.out.println(int1 + " + " + int2 + " = " + result);
                break;
            case '-':
                result = int1 - int2;
                System.out.println(int1 + " - " + int2 + " = " + result);
                break;
            case '/':
                result = int1 / int2;
                System.out.println(int1 + " / " + int2 + " = " + result);
                break;
            case '%':
                result = int1 % int2;
                System.out.println(int1 + " % " + int2 + " = " + result);
                break;
            case '*':
                result = int1 * int2;
                System.out.println(int1 + " * " + int2 + " = " + result);
                break;
            default:
                System.out.println("Invalid operator");
        }