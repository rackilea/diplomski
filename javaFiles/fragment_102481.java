String multimsg = "";
    while (counter <12)
    {
        counter = counter + 1;
        total = counter * num1;
        multimsg += ("The calculation is " + num1 + " x " + counter + "=" + total);
    }
    JOptionPane.showMessageDialog(null, multimsg);