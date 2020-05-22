public class MyObject {
    // Instance variables
    private String text;
    private boolean equipped;

    public MyObject() {
        // Default constructor
    }

    // setters
    public void setText(String text) {
        this.text = text;
    }
    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }

    // getters
    public String getText() {
        return this.text;
    }
    public boolean isEquipped() {
        return this.equipped;
    }

    // main method
    public static void main(String[] args) {
        MyObject o = new MyObject();
        o.setEquipped(true);
        o.setText("Knife");
        System.out.println("Is 'o' equipped?");
        System.out.println(o.isEquipped());
        System.out.println("What is 'o'?");
        System.out.println(o.getText());
    }
}