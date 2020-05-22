public class Calculator extends JFrame{

  public Calculator() {
  CalculatorPanel calc=new CalculatorPanel();
  getContentPane().add(calc);
  addWindowListener(new WindowAdapter() {

        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    });
   pack();
   setVisible(true);
  }