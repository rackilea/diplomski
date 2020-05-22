Map<Integer, Character> c = new HashMap<Integer, Character>();
    Scanner sa = new Scanner(System.in);
    for (int i = 0; i <1 ; i++) {
        System.out.println("Enter key");
       Integer a = sa.nextInt();
        System.out.println("Enter value");
        //added new code 
        String str = sa.next();
        char d = str.charAt(0);
        c.put(a,d);
    }
    System.out.println(c);