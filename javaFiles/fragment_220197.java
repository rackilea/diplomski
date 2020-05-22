for(;;) {
    if(!sc.hasNextInt() ) { 
        System.out.println("only integers!: "); 
        sc.next(); // discard
        continue;
    } 
    choose=sc.nextInt();
    if( choose<=0 || choose>30)
    {
        System.out.print("no, 1-30: ");
        continue;
    }
    break;
}