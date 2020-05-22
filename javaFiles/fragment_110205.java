import java.awt.*;

public class Example extends Frame {

    private MenuBar menuBar = new MenuBar();
    private Menu program = new Menu("Program");
    private Menu message = new Menu("Nachrichtenverwaltung");
    private MenuItem itmClose = new MenuItem("Schließen");
    private MenuItem itmWelcome = new MenuItem("Willkommen");

    public Example() {
        menuBar.add(program);
        menuBar.add(message);
        program.add(itmClose);
        message.add(itmWelcome);
        setMenuBar(menuBar);
        Panel panel = new Panel(){

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(320, 240);
            }
        };
        panel.setBackground(Color.cyan.darker());
        add(panel);
        pack(); 
        setVisible(true);
    }

    public static void main(String args[]) {
        Example wnd = new Example();
    }

}