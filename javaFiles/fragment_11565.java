public class Calculator {
    public static void main(String[] args) {

        JFrame application = new JFrame("Calculator");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(250, 200);

        CalField calField = new CalField();
        CalButton calButton = new CalButton();

        application.add(calField, BorderLayout.PAGE_START);
        application.add(calButton, BorderLayout.CENTER);

        application.setVisible(true);
    }
}