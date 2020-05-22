class Color{
    public final static Color RED = new Color("RED");
    public final static Color BLUE = new Color("BLUE");

    private String name;

    private Color(String name){
        this.name = name;
    }        

    public String toString(){
        return name;
    }
    //...rest of code like `values()`, and `ordinal()` methods
}