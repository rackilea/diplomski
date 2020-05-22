public class ScenarioContext {

    private  Map<String, Object> scenarioContext;

    public ScenarioContext(){
        scenarioContext = new HashMap<String, Object>();
    }

    public void setContext(Context key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    public Object getContext(Context key){
        return scenarioContext.get(key.toString());
    }

    public Boolean isContains(Context key){
        return scenarioContext.containsKey(key.toString());
    }
}