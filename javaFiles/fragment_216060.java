private Object conditionSync = new Object();

@Override
public void loop() {
    Thread.sleep(1000);
    synchronized(conditionSync) {
        if (thisIsTrue()) {                //Condition checked
            setThisFalse();                 //Set the condition above false
            thanDoSomethingElse();         //Method to executed ONLY ONCE
        }
    }
}