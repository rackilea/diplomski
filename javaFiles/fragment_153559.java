Scanner input = new Scanner(System.in);
int Rows = 0;
while (Rows <= 0) { // Keep asking the user if they enter something less than zero
    System.out.print("How many rows do you want in your triangle, more than 0?: ");
    Rows = input.nextInt(); 
    }

// If you got out of the while loop, that means you got a positive row number

for (int i = 1; i <= Rows; i++) { // number of lines
    for (int j = 1; j <= i; j++) // number of stars at each line
        System.out.print("*"); // printing stars
    System.out.print("\n"); // line break
    }