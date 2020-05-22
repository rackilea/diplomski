void func(){                                                                                             
  try {                                                                                                  
    PrintStream out=new PrintStream(new BufferedOutputStream(new FileOutputStream("output.txt")));       
    System.out.println("Enter a value:");                                                                
    out.println("Enter a value:");                                                                       
    Scanner in1=new Scanner(System.in);                                                                  
    int i= in1.nextInt();                                                                                
    out.println(i);                                                                                      
    System.out.println("i="+i);                                                                          
    out.println("i="+i);                                                                                 
    out.close();                                                                                         
  } catch (FileNotFoundException e) {                                                                    
    System.err.println("An error has occurred "+e.getMessage());                                         
    e.printStackTrace();                                                                                 
  }
}