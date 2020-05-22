String requiredOperator =... // input

File file = new File("c:\\myclasses\\");
URL url = file.toURL();          // file:/c:/myclasses/
URL[] urls = new URL[]{url};

// Create a new class loader with the directory
ClassLoader cl = new URLClassLoader(urls);

// Load in the class; MyClass.class should be located in
// the directory file:/c:/myclasses/com/mycompany
// Class cls = cl.loadClass("com.mycompany.MyClass"); <= how to load a class
Class[] classes; // load your classes: Plus.class, Minus.class into this array
classes = new Class[]{ cl.loadClass("com.mycompany.Plus"), cl.loadClass("com.mycompany.Minus") };
Method method;
Object instance;
String identifier;
for(Class cls : classes)
{
    instance = cls.newInstance();
    method = cls.getMethod("getOperator", null); // method getOperator of Operator interface does not have any parameter
    identifier = (String)method.invoke(instance, null);
    if(identifier.equals(requiredOperator))
    {
        method = cls.getMethod("calculate", new Class[] { double.class, double.class } ); // two params are double
        return (double)method.invoke(instance, double1, double2);
    }
}