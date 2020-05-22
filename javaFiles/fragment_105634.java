import java.awt.Color;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class Test
{
    public static void main ( String [] args )
    {
        Field [] names = Color.class.getFields();
        ArrayList < String > list = new ArrayList < String >();

        for ( Field name: names )
            list.add( name.getName() );
        for ( int i = 0; i < list.size(); i++ )
            System.out.println( list.get( i ) );
    }
}