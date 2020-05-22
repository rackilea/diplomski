import javax.swing.JButton;

public class Demo {

  public static void main(String[] args) {

    IPrintable instance1 = new PrintableButton();
    instance1.print();

    PrintableButton instance2 = new PrintableButton();
    instance2.print();
  }
}

interface IPrintable {
  public void print();
}

class PrintableButton extends JButton implements IPrintable {
  private static final long serialVersionUID = 1L;

  @Override
  public void print() {
    System.out.println("Printable Button");
  }
}