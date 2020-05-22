System.out.println("Either enter t for plain text\n or h for HTML");
    Scanner input = new Scanner(System.in);
    String  answer = input.nextLine();

    if(answer.equalsIgnoreCase("H")){
        System.out.println("wowwwwww you chose HTML");

        }
    else if( answer.equalsIgnoreCase("T")){
        System.out.println("wowwwwww you chose plain text");
     }
}