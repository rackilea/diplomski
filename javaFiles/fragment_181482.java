public List<IMethodInstance> intercept(List<IMethodInstance> methods,ITestContext context) 
{

    List<IMethodInstance> result = new ArrayList<IMethodInstance>();
    int array_index=0;

    for (IMethodInstance m : methods)
    {
        result.add(m);
    }
    //Now iterate through each of these test methods
    for (IMethodInstance m : methods)
    {
        try {               
            //Get the FIELD object from - Methodobj->method->class->field
            Field f = m.getMethod().getRealClass().getField("priority");
            //Get the object instance of the method object              
            array_index=f.getInt(m.getInstance());
        } 
         catch (Exception e) {
            e.printStackTrace();
        }           
        result.set(array_index-1, m);           
    }

    return result;
}