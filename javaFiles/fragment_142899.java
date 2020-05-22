import javax.swing.*;

// The "number 4" class.
public class number4
{
    public static void main (String[] args)
    {            
        String word = JOptionPane.showInputDialog ("Enter a word:");
        int len = word.length ();
        String SPACES = "                              ";       
        for (int i = 0 ; i < len; i++)
        { 
            System.out.print(SPACES.substring(0,i));            
            System.out.print (word.substring (0,i) + System.lineSeparator());           
        }            
        for (int g = len ; g>=0; g--)
        {          
            System.out.print(SPACES.substring(0,g));           
            System.out.print (word.substring (0,g) + System.lineSeparator());              
        }        
        System.out.println();
    } // main method
} //number 4