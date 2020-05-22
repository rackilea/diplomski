import java.util.*;

public class GuessGame 
{
    public static void main ( String [] args )
    {
        char [] ca = "This is a test!".toCharArray ();
        List <Character> ls = new ArrayList <Character> ();
        for (char c: ca)
            ls.add (c);

        show (ls);
        // first method: remove from top/end and step backwise:
        for (int i = ls.size () - 1; i >= 0; --i)
        {
            char c = ls.get (i); 
            if (c == 'i' || c == 'a' || c == 'e')
                ls.remove (i); 
        }
        show (ls);

        // second approach: collect elements to remove ...
        ls = new ArrayList <Character> ();
        for (char c: ca)
            ls.add (c);
        show (ls);
        // ... in a separate list and 
        List <Character> toRemove = new ArrayList <Character> ();
        for (char c: ls)
        {
            if (c == 'i' || c == 'a' || c == 'e')
                toRemove.add (c); 
        }
        // ... remove them all in one go:
        ls.removeAll (toRemove);
        show (ls);
    }

    private static void show (List <Character> ls)
    {
        for (char c: ls)
            System.out.print (c + " ");
        System.out.println ();
    }   
}