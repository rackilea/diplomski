interface MyConfig {
     double getWeightOfBomb();
 }

 class SomeClass {
    private MyConfig myConfig;

    public void doSomething() {
       myConfig.getWeightOfBomb();
    }
 }

 class MyConfigImpl implements MyConfig {
     public double getWeightOfBomb() {           
          return MyConfiguration.getInstance().getWeightOfBomb(); 
     }
 }