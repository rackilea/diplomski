class MyClass{
  private final int intVar;  //ok
  private final Paint paint;// paint = new Paint(); to avoid //error "Variable paint might not have been initialized"

  public MyClass(){
       intVar = 12; 
       //initializePaint(); 
       paint = new Paint(); // here initialized And allowed.
  }

  private void initializePaint(){
       paint = new Paint();  //error  "cannot assign a variable to final variable"
  }
}