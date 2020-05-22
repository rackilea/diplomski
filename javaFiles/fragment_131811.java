public class ThreadDemo 
{   

  public static void main(String args[])    
  {         

    //Creating an object of the first thread        
    FirstThread   firstThread = new FirstThread();              

    //Creating an object of the Second thread       
    SecondThread   secondThread = new SecondThread();               

    //Starting the first thread         
    firstThread.start();                

    //Starting the second thread        
    secondThread.start();   
  } 
}