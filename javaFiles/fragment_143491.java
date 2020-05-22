public MyList() {   //takes no arguments
    nodes = null;
}
public MyList(T... args) {  //takes any number of arguments
    this();
    for(T t : args){
        add(t);
    }
}