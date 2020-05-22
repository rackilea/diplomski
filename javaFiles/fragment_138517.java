public void someMethod() {
    synchronized(listOfString) { //use the same lock!
        if(listOfString.size() == 123) {
            listOfString.add("lucky day");
        }
    }
}