String x = JOptionPane.showInputDialog(null, "Hur många värden haver du?");

    int i = Integer.parseInt(x);
    int sum = 0;
    for (int y = 0; i > y; y++) 
    {
        String z = JOptionPane.showInputDialog(null, "Skriv in värdet");
        sum = (sum + Integer.parseInt(z));
    }
    System.out.println(sum);