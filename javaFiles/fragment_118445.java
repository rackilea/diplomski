String acc = "";

for (int i = 0; i < LoansList.size(); i++)
{
    Loans myLoans = (Loans) LoansList.get(i); 

    acc += myLoans.showDetails () + "\n";
}

JOptionPane.showMessageDialog(null, acc, "", JOptionPane.INFORMATION_MESSAGE);