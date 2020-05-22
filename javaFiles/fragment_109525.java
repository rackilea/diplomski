Scanner sc = new Scanner(System.in);
    System.out.println("Enter the character in continuation to get the pattern");
    String s = sc.next();

    int d = s.length();
    for(int i = 0; i < d; i++)
    {    
        s = s.substring(1, d) + s.charAt(0);
        System.out.println(s);
    }