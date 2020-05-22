import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Distance {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Insert two point to calculate the distance. Format: (x1,y1) (x2,y2) : ");

        Pattern pattern = Pattern.compile("^\\((-?\\d+),(-?\\d+)\\)\\s\\((-?\\d+),(-?\\d+)\\)$");
        Matcher matcher = pattern.matcher( input.nextLine ( ) );

        if ( matcher.matches ( ) )
        {
            System.out.println ( "Good" );
            double dist = Math.sqrt( Math.pow ( Long.parseLong ( matcher.group(3) ) - Long.parseLong ( matcher.group(1) ) , 2 ) + 
                    Math.pow ( Long.parseLong ( matcher.group(4) ) - Long.parseLong ( matcher.group(2) ) , 2 ) );
            System.out.println ( "Distance: " + dist );
        }

        else
        {
            System.out.println ( "Wrong input format" );
        }

    }

}