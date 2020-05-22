class Group { // Each Group is composed of positions
    //fields definitions (and probably initialization of fields)...
    //field declaration
    ArrayList<String> stringList = new ArrayList<String>();
    //this code can't be here
    //stringList.add("Item");

    Group() {
        //move it here
        stringList.add("Item");
        //...
    }

    //rest of code...
}