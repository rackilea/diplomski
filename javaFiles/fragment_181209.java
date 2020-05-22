while(!done) // (1)
{
    String answer = JOptionPane.showInputDialog(null, "message");

    if (answer == null) finish();

    try
    {
        sales = Double.parseDouble(answer); // (2)
        if (sales<= 0) throw new NumberFormatException();
        else done = true; // (3)
    }