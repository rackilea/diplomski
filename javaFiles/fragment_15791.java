InputStream input = null;  
try
{
    input YourClassName.class.getClassLoader.getResourceAsStream("props.xml");
    if (input == null)
    {
         // Throw an appropriate exception here to show you can't find your file
    }
    prop.loadFromXML(input);
}
finally
{
    if (input != null)
    {
        input.close();
    }
}