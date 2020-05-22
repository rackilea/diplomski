public class Test1 {
    //static Logger logger; //no need to create an object for logging

    public Test1()throws IOException {

         MyLogging.log(Level.INFO, MyLogging.class.getName()); //call log method using classname
    }