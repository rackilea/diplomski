try{
    Scanner innfil=new Scanner(new File("minfil55.txt"));
    char a=innfil.nextLine().charAt(0); //first error was here. calling next() only
                                        //read A and not the \r\n at the end of the 
                                        //line. Therefore, the line after this one was 
                                        //only reading a newline character and the 
                                        //nextInt() was trying to read the "Canis" line.
    String b=innfil.nextLine(); 
    System.out.println(a +b);
    int c=(int)innfil.nextInt(); 
    innfil.nextLine(); //call next line here to move to the next line.
    double d=(double)innfil.nextDouble();
    innfil.close();
}
catch(Exception e){
    e.printStackTrace();
}