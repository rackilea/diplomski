public void Test_myMethod_With_Null_MyClass_Does_Not_Call_someMethod()
{
    try
    {
        Util.myMethod(null);
    }
    catch( ExpectedException e )
    {
        fail( "Should not have thrown exception: " + e.getMessage() ); 
    }
}