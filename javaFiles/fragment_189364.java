public class Test {
 public static void main( String[] args ) throws Exception
    {
        HashMap<String, Person> personMap = new HashMap<String, Person>();
        try
        {
            BufferedReader in = new BufferedReader( new FileReader( "File Path" ) );
            String str;
            Person person = new Person();
            int count = 0;
            String key = "";
            while( ( str = in.readLine() ) != null )
            {

                if ( null != str && str.trim().length() == 0 )
                {
                    personMap.put( key, person );
                    count = -1;
                    person = new Person();
                }
                else {
                    String arr[] = str.split( " " );
                    key = arr[0];
                    if (count == 0) {
                        person.setName( arr[1] );
                    }
                    else if (count == 1) {
                        person.setAge(  arr[1] );
                    }
                    else if (count == 2) {
                        person.setAddress(  arr[1] );
                    }
                }
                count ++;
            }
            personMap.put( key, person );
            in.close();
        }
        catch( IOException e )
        {
            System.out.println( "Exception" + e.getMessage() );
        }
    }
}

public class Person
{
    private String name    = null;

    private String age     = null;

    private String Address = null;

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getAge()
    {
        return age;
    }

    public void setAge( String age )
    {
        this.age = age;
    }

    public String getAddress()
    {
        return Address;
    }

    public void setAddress( String address )
    {
        Address = address;
    }

}