int david[] = new int[10];
    System.out.println("Enter your 10 digit number: ");
    Scanner scan = new Scanner(System.in);
    String str = scan.next();
    if (str.length() < david.length) {
        System.out.println("invalid number");
    }
    for (int i = 0; i < david.length; i++) {

        david[i] = Character.digit(str.charAt(i), 10);
    }
    System.out.println(Arrays.toString(david));