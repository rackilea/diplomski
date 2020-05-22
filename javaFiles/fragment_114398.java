interface ValSetter {
    void set(RetryLogic logic, String val);
}
// The map can be made static in a class
Map<String,ValSetter> setterForName = new HashMap<>();
{ // Initializer block
    setterForName.put("maximumredeliveries", new ValSetter() {public void set(RetryLogic logic, String val) { logic.setMaximumRedeliveries(val);}} );
    setterForName.put("asyncrelayedredelivery", new ValSetter() {public void set(RetryLogic logic, String val) { logic.setAsyncDelayedRedelivery(val);}} );
}