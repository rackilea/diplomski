public class MyGUI {
    public static void main(String[] args) {
        Frame f = new Frame("Layout Example");
        Panel mainPanel = new Panel(new BorderLayout());
        f.add(mainPanel);

        Panel toolBar = new Panel(new FlowLayout());
        toolBar.add(new Button("Button 1"));
        toolBar.add(new Button("Button 2"));
        mainPanel.add(tollBar.NORTH);

        Panel statusBar = new Panel(new FlowLayout());
        statusBar.add(new Label("Status"));
        mainPanel.add(statusBar);

        f.pack();
        f.show();
    }
}