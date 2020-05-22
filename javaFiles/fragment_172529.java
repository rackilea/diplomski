While(true)
{
    ans = JOptionPane.showInputDialog(null, "Enter amount to be withdrawn from checking");
    double withCheck = Double.parseDouble (ans);
    if (withCheck >= checking)
        {
        JOptionPane.showMessageDialog(null, "You do not have enough in your account for that.");
        }
    else
        {
        double sum = checking - withCheck;
        JOptionPane.showMessageDialog(null, "Your checking balance is now: $" + sum + ", and your savings balance is: $" + savings);
        break;
        }
    }
}