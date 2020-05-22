Scanner in = new Scanner(System.in);
    System.out.print("Enter key: ");
    int key = in.nextInt();
    in.nextLine();
    System.out.print("Enter line: ");
    String str = in.nextLine();

    System.out.println( Cipher.encode( str, key ));