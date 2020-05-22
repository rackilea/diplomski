CREATE OR REPLACE AND COMPILE JAVA SOURCE NAMED My_JavaClass AS
import java.io.*;
public class DBTrigger 
{
    public static void logSal()
    {
     System.out.println("In java class");
    }
}
/