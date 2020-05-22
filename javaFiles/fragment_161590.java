for (Iterator<String> it = stringList.iterator(); it.hasNext(); ) {
    String currentString = it.next();
    //now, it's more clear that you're updating the variable currentString
    //that holds a copy of the reference stored in the List
    //this explains why this approach won't work
    if (currentString.equals("hello")) {
        currentString = "bye";
    }
}