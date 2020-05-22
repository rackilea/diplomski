public class Container {
    private final static Map<PrintTask, Map<String, String>> values = new HashMap<>();

    public static void putTaskToMap(PrintTask key, Map<String, String> values) {
        synchronized(values) {
            values.put(key, values);
        }
    }

    public static Map<String, String> getValues(PrintTask key) {
        syncronized (values) {
        Map<String, String> retVal = values.get(key);
        if(retVal == null) {
             retVal = Collections.synchronizedMap(new HashMap<String, String>());
             values.put(retVal);
        }
        return retVal;
        }
    }
}

public class PrintTask extends Runnable {
@Override
public void run() {
    Map<String, String> map = Container.getValues(this);
    map.put(name + " is running", name + " is running");
    System.out.println(name + " is running");

    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    System.out.println(name + " is running");
}

public void someOtherMethod() {
    Map<String, String> values = Container.getValues(this);
    // the values here will always be the _same_ Map containing the same contents as the one in run.
}