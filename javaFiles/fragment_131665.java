public class Printer {

public enum Color{
    RED("#FF0000"), GREEN("#00FF00"), BLUE("#0000FF");

    private String colorAsString;

    private Color(String colorAsString) {
        this.colorAsString = colorAsString;
    }

    public String getColorAsString() {
        return this.colorAsString;
    }
}

public void print (Color color){
    MyElement myElement = new MyElement();
    myElement.setColor(color.getColorAsString());
    myElement.print();
}