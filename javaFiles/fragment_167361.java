int n;
do {
   n = Integer.parseInt(JOptionPane.showInputDialog(null,
       "Enter a number between 1 and 10"));
   if (n >= 1 && n <= 10) {
     break;
   }
   JOptionPane.showMessageDialog(null,"Your number is not between 1 and 10");
} while (true);

// do something useful with n, will you? )