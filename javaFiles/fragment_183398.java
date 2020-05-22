public class SomeClass{
  private final SystemExit exiter;
  private final static String QUIT = "quit";
  public SomeClass(){
    this(new SystemExit());
  }

  SomeClass(SystemExit exiter){
    this.exiter = exiter;
  }

  public static void exitWhenQuitDetected() {    
    String line = "";    
    try {    
      final InputStreamReader input = new InputStreamReader(System.in);    
      final BufferedReader in = new BufferedReader(input);    
      while (!(line.equals(QUIT))) {    
        line = in.readLine();    
        if (line.equals(QUIT)) {    
          System.out.println("You are now quiting the program");                      
          exiter.exit(1);    
        }    
      }    
    } catch (Exception e) {    
      System.err.println("Error: " + e.getMessage());    
    }    
  }       

  // ...
}