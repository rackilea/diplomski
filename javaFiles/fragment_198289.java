public class SVMServiceImpl implements Classify,AnotherInterface{


    public static void main(String[] args) 
    {
        MLService mlserv = new SVMServiceImpl();
        /**
         * Your Algo-based on this below's typecasting should happen
         */
        ((Classify)mlserv).classifyMethod();//or ((AnotherInterface)mlserv).anotherMethod();

    }
}