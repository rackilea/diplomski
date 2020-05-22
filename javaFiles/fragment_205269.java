String input = "0100101"; 
    final int n=input.length();
    Random generator = new Random();
    char c=0;
    int i=0;
    do{
        i = generator.nextInt(n);           
        c=input.charAt(i);
    }while(c!='1');
    System.out.println(i);