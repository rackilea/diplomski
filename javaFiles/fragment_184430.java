...
    } //end while loop for weekend.

    choice = JOptionPane.showInputDialog(null, "Do you want to calculate another weeks wages -Yes or No?", "TRY AGIN", JOptionPane.PLAIN_MESSAGE);

} while (choice.equals("Y") || choice.equals("y"));
JOptionPane.showMessageDialog(null, "Pay this week is £" + wages, "Pay", JOptionPane.PLAIN_MESSAGE);