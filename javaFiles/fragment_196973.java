public static void main(String[] args) throws Exception
{
    //this is only to demonstrate java reflection:
    Method[] publicMethods = TestPojo.class.getMethods(); //get all public methods
    TestPojo testObj = TestPojo.class.newInstance(); //when you have a default ctor (otherwise get constructors here)
    for (Method aMethod : publicMethods) //iterate over methods
    {
        //check name and parameter-count (mabye needs some more checks...paramter types can also be checked...)
        if (aMethod.getName().startsWith("set") && aMethod.getParameterCount() == 1)
        {
            Object[] parms = new Object[]{"test"}; //only one parm (can be multiple params)
            aMethod.invoke(testObj, parms); //call setter-method here
        }
    }
}