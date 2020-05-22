class Window{
    Oscillo parent;
    Graph graph;
    boolean b1=true;
    boolean b2 = false;

    Window(Oscillo parent){
        this.parent = parent;
    }

    // I would urge you to choose better names that are more clear
    // for both variables and methods
    boolean getB1() { return b1; }
    boolean getB2() { return b2; }

}//end class