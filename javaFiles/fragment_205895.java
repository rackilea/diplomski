private void initStuff () {
    calculateButton.addActionListener(new ButtonActionEvent());
    clearButton.addActionListener(new ButtonActionEvent());
    fahrFld.addKeyListener(new MyKeyAdapter());
    celsFld.addKeyListener(new MyKeyAdapter());
    kelvFld.addKeyListener(new MyKeyAdapter());
}

private JTextField lastModified;

private class MyKeyAdapter extends KeyAdapter {
    @Override
    public void keyTyped(KeyEvent e) {
        lastModified = (JTextField)e.getSource();
    }
}

private class ButtonActionEvent implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {
        //declare three constant values for absolute zero
        double A_ZERO_F =  -459.67;
        double A_ZERO_C = -273.15;
        double A_ZERO_K = 0.0;

        if(lastModified == fahrFld)
        {
            double input = Double.parseDouble(fahrFld.getText());

            //fahrenheit to kelvin
            double kelvVal = ((input-32.0)/1.8) + 273.15;
            kelvFld.setText("" + kelvVal);

            //fahrenheit to celsius
            double celsVal = (5.0/9.0) * (input-32.0);
            celsFld.setText(""+ celsVal);
        }
        else if(lastModified == celsFld)
        {
            double input = Double.parseDouble(celsFld.getText());

            //celsius to fahrenheit
            double fahrVal = ((9.0/5.0)*input) + 32.0;
            fahrFld.setText(""+ fahrVal);

            //celsius to kelvin
            double kelvVal = input + 273.15;
            kelvFld.setText(""+ kelvVal);
        }
        else if(lastModified == kelvFld)
        {
            double input = Double.parseDouble(kelvFld.getText());

            //kelvin to fahrenheit
            double fahrVal = ((input - 273) * 1.8 ) + 32.0;
            fahrFld.setText("" + fahrVal);

            //kelvin to celsius
            double celsVal = input - 273.15;
            celsFld.setText(Double.toString(celsVal));
        } else {
            return;
        }

        //clears all conversions when clear button is pressed
        if (event.getSource() == clearButton){
            celsFld.setText("");
            kelvFld.setText("");
            fahrFld.setText("");
        }
    }
}