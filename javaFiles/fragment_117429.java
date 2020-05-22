public class TEST
{
    public static void main( String[] args )
    {
        String s = "the location is at {emp.address.street} with the name {emp.name},{emp.surname}";
        String result = s.replaceAll( "[^{}]+|(\\{(.*?)\\})", "$1" );
        System.out.println(result);
    }
}