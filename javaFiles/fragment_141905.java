import java.util.Arrays;
import java.util.regex.Pattern;

public class Nzero
{
    public static void main ( String [ ] args )
    {

        int [ ] arr1 = { 0 , 0 , 0 , 2 , 0 , 2 , 0 , 2 , 0 , 0 };
        int [ ] arr2 = { 12 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , - 8 };
        int [ ] arr3 = { 0 , 0 , 0 , 0 , 5 , 0 , 0 , 4 , 0 , 0 , 6 };
        int [ ] arr4 = { 0 , 0 , 0 , 0 , 5 , 0 , 0 , 4 , 0 , 0 , 0 , 6 };
        int [ ] arr5 = { 0 , 0 , 0 , 0 , 5 , 0 , 4 , 0 , 0 , 6 };
        int [ ] arr6 = { 0 , 0 , 0 , 0 };
        int [ ] arr7 = { 0 , 0 , 1 , 0 , 0 };

        System.out.println ( isNzeroPack ( arr1 , 1 ) ); // true
        System.out.println ( isNzeroPack ( arr2 , 7 ) ); // true
        System.out.println ( isNzeroPack ( arr3 , 2 ) ); // true
        System.out.println ( isNzeroPack ( arr4 , 2 ) ); // false
        System.out.println ( isNzeroPack ( arr5 , 2 ) ); // false
        System.out.println ( isNzeroPack ( arr6 , 3 ) ); // false
        System.out.println ( isNzeroPack ( arr7 , 2 ) ); // false

    }

    private static boolean isNzeroPack ( int [ ] arr , int n )
    {

        String numbers = Arrays.toString ( arr ).replaceAll ( "\\[|\\]|,|\\s" , "" );
        numbers = numbers.replaceAll ( "[0]+$" , "" );
        numbers = numbers.replaceFirst ( "^0+(?!$)" , "" );
        //informational print
        System.out.println ( numbers );

        Pattern pattern = Pattern.compile ( "^(((-*)[1-9]+)([0]{" + n + "})+)+((-*)[1-9]+)$" );
        return numbers.length ( ) < 2 ? false : pattern.matcher ( numbers ).find ( );

    }

}