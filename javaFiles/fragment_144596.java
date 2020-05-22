public class StepDefinitions{
 private static HashMap<Integer,String> scenarios;

public StepDefinitions(){ //or even inside of your singleton's getInstance();
 if(scenarios == null)
   scenarios = new HashMap<Integer,String();
}

@Before
public void beforeHook(Scenario scenario) {
    addScenario(scenario.getName());
}

@When("your step definition")
public void stepDefinition1(){
   String scenario = getScenario(); //problem-o-solved here...
}


private void addScenario(String scenario){
     Thread currentThread = Thread.currentThread();
     int threadID = currentThread.hashCode();
     scenarios.put(threadID,scenario);
}

private synchronized String getScenario(){
     Thread currentThread = Thread.currentThread();
     int threadID = currentThread.hashCode();
     return scenarios.get(threadID);
}