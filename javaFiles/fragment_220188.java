package example;

    import java.util.Date;

    public class HelloWorld 
    {
        public HelloWorld() 
        {

        }
        public String getHelloWorld(String name,String name1) 
        {
            String result = null;
            result = name + " and " + name1;
            return result;
        }
        public String getCurrentDate(String name)
        {
            String result = null;
            result = " Current Date is:" + new Date();
            return result;
        } 
    }