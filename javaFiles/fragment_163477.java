import java.util.*;
import java.lang.*;
import java.io.*;

class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println(validateName("Dąb_rośnie$gdzieś#tu"));
        System.out.println(validateName("Some_string_here"));
    }
    private static boolean validateName(String name) { 
        if (name.matches("(?U)\\p{L}+(?:[\\W_]\\p{L}+)*")) { 
            return true; 
        } 
        return false; 
    } 
}