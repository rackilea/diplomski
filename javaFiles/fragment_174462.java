public static MyInterface loadMyInterface( String userClass ) throws Exception
{
    // Load the defined class by the user if it implements our interface
    if ( MyInterface.class.isAssignableFrom( Class.forName( userClass ) ) )
    {
        return (MyInterface) Class.forName( userClass ).newInstance();
    }
    throw new Exception("Class "+userClass+" does not implement "+MyInterface.class.getName() );
}