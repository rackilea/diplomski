package utils;

public class MySingleton {
    private static MySingleton ourInstance = new MySingleton();
    private String myModel = null;

    public static MySingleton getInstance() {
        return ourInstance;
    }

    private MySingleton() {
        play.Logger.debug("READING FILE AND SETTING myModel field... almost ;)");
        myModel = "Value from somewhere";
    }

    public String getMyModel() {
        return myModel;
    }
}