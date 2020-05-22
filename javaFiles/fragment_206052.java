class CustomPanel extends JPanel {
    JButton button=new JButton("Some button");

    public JButton getMyButton() {
        return button;
    }
}

class Test {
    CustomPanel cp=new CustomPanel();


    void someMethod() {
       JButton b= cp.getMyButton();
    }
}