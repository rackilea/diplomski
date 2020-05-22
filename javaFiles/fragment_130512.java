import java.io.*;
import java.util.*;

public class Lab5
{
    public static void main (String[] args) throws Exception
    {
        boolean isUnique = true;
        HashSet<String> set = new HashSet<String>();
        BufferedReader infile = new BufferedReader( new FileReader( args[0] ) );
        while ( infile.ready() ) 
        {
            String word = infile.readLine();
            if ( !set.add(word) ) {
                isUnique = false;
                break;
            }
        }

        System.out.println(isUnique ? "UNIQUE \n" : "NOT_UNIQUE \n");

    } 
}