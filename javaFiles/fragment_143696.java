public class Test
{
    public static void main(String[] args) throws Exception
    {
        Thread.currentThread().setContextClassLoader(new MyClassLoader());
        SomeClass someClass = new SomeClass();
        someClass.printClassLoader();
    }

    public static class MyClassLoader extends ClassLoader
    {
        public MyClassLoader()
        {
            super();
        }

        public MyClassLoader(ClassLoader parent)
        {
            super(parent);
        }
    }
}



public class SomeClass
{
    public void printClassLoader()
    {
        System.out.println(this.getClass().getClassLoader());
        System.out.println(Thread.currentThread().getContextClassLoader());
    }
}