public class Main {

    public static void main(String[] args) {
    String test = "no";  
    try  {  
        System.out.println("start try");  
        doRisky("yes"); 
        System.out.println("end try"); 
        } 
    catch( ScaryException se)  {        
        System.out.println("in catch");  
        }  
    finally  {  
        System.out.println( "finally") ; 
        } 
    System.out.println("end of main");

    }

    static void doRisky(String test) throws ScaryException  {  
        System.out.println("start risky");  
        if ("yes".equals(test))  { 
            throw new ScaryException("Scary Exception thrown from doRisky"); 
            }  
        System.out.println("end risky"); 
        return;  
}

}