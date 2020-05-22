public class Question
{ 
    public static void main(String args[])
    {
        int year;    
        java.util.Calendar current = java.util.Calendar.getInstance(); //Creating the calendar class object
        year = current.get(java.util.Calendar.YEAR); //Initializing year with calendar class object
        System.out.println ("Current Year: "+year); // Printing year
    } 
}