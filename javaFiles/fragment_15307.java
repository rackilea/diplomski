System.out.println("Do You Want more Calculation...Yes/No");
    input.nextLine(); // this is what I added
    String str1=input.nextLine();

    if("no".equals(str1))
    {
        go=false;
        System.out.println("Thanks For using...Bye");
    }