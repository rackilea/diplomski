import java.util.Optional;

public class Test {

    private static String myObject;

    public void setupMyObject(){
        synchronized(Test.class){
            myObject = Optional.ofNullable(myObject).orElse(SomeConfig.ofDefaults());
        }
    }

}