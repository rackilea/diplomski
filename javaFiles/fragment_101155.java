public Void doInBackground() {
    for(Object o : objects) {
        doSomething();
        publish("Done for " + o);                           
    }                                             
}

@Override
protected void process(List<String> messages) {
    for (String message : messages) {
        MyGlobalGUIConsole.addMessage(message);
    }
}