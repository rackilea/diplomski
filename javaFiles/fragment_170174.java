import java.util.*;

public class Project1 {
    public static char getNumber(char letter) {
        char ret = 0;
        if( letter < 'A' )
        {
            ret = '0';
        }
        else if( letter < 'D' )
        {
            ret = '2';
        }
        else if( letter < 'G' )
        {
            ret = '3';
        }
        else if( letter < 'J' )
        {
            ret = '4';
        }
        else if( letter < 'M' )
        {
            ret = '5';
        }
        else if( letter < 'P' )
        {
            ret = '6';
        }
        else if( letter < 'T' )
        {
            ret = '7';
        }
        else if( letter < 'W' )
        {
            ret = '8';
        }
        else if( letter <= 'Z' )
        {
            ret = '9';
        }
        else
        {
            ret = '0';

        }
        return ret;
    }

    public static void main (String[] arg) {
        Scanner input = new Scanner(System.in);
        System.out.println( "Please enter a 7 letter phrase: " );
        String number = input.nextLine().toUpperCase();
        StringBuffer buff = new StringBuffer();
        for( int i = 0, j = 0; j < number.length() && i < 7; j++ )
        {
            char c = number.charAt(j);
            if( c != ' ' )
            {
                if( i == 3 )
                {
                    buff.append( '-' );
                }
                buff.append( getNumber( c ) );
                i++;
            }
        }
        System.out.println( buff );
    }
}