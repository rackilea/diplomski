package other;

import java.util.*;
import java.util.function.Function;

public class FunctionExample {
    private static class Employee{
        private String name;
        private int number;
        Employee(String name, int number){
            this.name=name;
            this.number = number;
        }

        private int getNumber( ) {

            return number;
        }

        private String getName( ) {

            return name;
        }
    }

    Function< Employee, Map< String, Integer > > funcEmpToString = ( Employee e ) -> {
        Map map = new HashMap< String, Integer >( );
        map.put( e.getName( ), e.getNumber( ) );
        return map;
    };

    public static List< String > convertEmpListToNamesList( List< Employee > employeeList, Function< Employee, String > funcEmpToString ) {

        List< String > empNameList = new ArrayList< String >( );
        for ( Employee emp : employeeList ) {
            empNameList.add( funcEmpToString.apply( emp ) );
        }
        return empNameList;
    }

    public static void main( String args[] ) {

        Function< Employee, String > funcEmpToString = ( Employee e ) -> { return e.getName( );};

        List< Employee > employeeList = Arrays.asList( new Employee( "Tom Jones", 45 ),
                new Employee( "Harry Major", 25 ),
                new Employee( "Ethan Hardy", 65 ),
                new Employee( "Nancy Smith", 15 ),
                new Employee( "Deborah Sprightly", 29 ) );

        List< String > empNameList = convertEmpListToNamesList( employeeList, funcEmpToString );
        empNameList.forEach( System.out::println );
    }
}