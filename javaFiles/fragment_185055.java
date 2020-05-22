public class MyApplication extends Application {

    private HashMap<String, String> variables = new HashMap<>();

    public String getVariable(String key) {
        return variables.get(key);
    }

    public void setVariable(String key, String value) {
        variables.put(key, value);
    }
}