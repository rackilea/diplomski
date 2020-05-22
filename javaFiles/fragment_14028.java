//This is your class
class Foo {

    private String bar;

    public Foo(String bar) {
        this.bar = bar;
    }

    public String getBar() {
        return this.bar;
    }
}

//This is your Frame
class gui {
    public static void main(String args[]){
        JFrame frame = new JFrame("My First GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        Foo foo = new Foo("HELLO WORLD");
        JLabel labelBar = new JLabel(foo.getBar());
        frame.getContentPane().add(labelBar);
        frame.setVisible(true);
    }
}