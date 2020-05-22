import javax.swing.JOptionPane;

public class Bank {
    public static double totalCash = 0;

    public static void main(String[] args) {
        boolean more = true;
        Deposite dep = new Deposite();
        Withdraw with = new Withdraw();
        while (more) {
            double cash = Double.parseDouble(JOptionPane.showInputDialog("Cash Deposite"));
            dep.depositeCash(cash);
            dep.print();
            int con = JOptionPane.YES_NO_OPTION;
            int con1 = JOptionPane.showConfirmDialog(null, "Do you want more Deposites?", "DEPOSITORY", con);
            if (con1 == 1) {
                int con3 = JOptionPane.showConfirmDialog(null, "Withdraw now?", "WITHDRAWAL", con);
                if (con3 == 0) {
                    cash = Double.parseDouble(JOptionPane.showInputDialog("Cash Withdraw"));
                    with.withdrawCash(cash);
                    with.print();
                    System.out.println("Thanks");
                    more = false;
                }
            }
        }
    }
}

class Withdraw {
    public double withdrawCash(double withdraw) {
        Bank.totalCash -= withdraw;
        return Bank.totalCash;
    }

    void print() {
        System.out.printf("You Cash Balance now is $%5.2f", Bank.totalCash);
        System.out.println(" ");
    }
}

class Deposite {
    public double depositeCash(double cash) {
        Bank.totalCash += cash;
        System.out.println(Bank.totalCash);
        return Bank.totalCash;
    }

    void print() {
        System.out.printf("Your deposite is :" + Bank.totalCash);
        System.out.println(" ");
    }
}