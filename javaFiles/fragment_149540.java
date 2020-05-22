public class myButtonAction implements ActionListener{

    private MyClass mc;

    public myButtonAction(MyClass mc) {
        this.mc = mc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      mc.anotherMethod();
    }
}