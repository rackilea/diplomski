double oldPounds = Double.parseDouble(JOptionPane.showInputDialog("How many old pounds? "));
 double oldShillings = Double.parseDouble(JOptionPane.showInputDialog("How many old shillings? "));
 double oldPennies = Double.parseDouble(JOptionPane.showInputDialog("How many old pennies? "));

 double newPounds = ((oldPounds*160.80) + (oldShillings*8.04) + (oldPennies*0.67));

 System.out.print("Your old pounds shillings and pennies are equal to £4"
            + "" + newPounds + ".");