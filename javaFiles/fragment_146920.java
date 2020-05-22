private static JLabel calculatorDisplay;
    public static JLabel generateCalculatorDisplay ()
    {
      if(calculatorDisplay != null)
            {
                //tiny hack so i could quickly check it works. 
                //better move it to an update display method
                calculatorDisplay.setText(displayText);
                return calculatorDisplay;
            }
            calculatorDisplay = new JLabel();
            // Legt die Größe des JLabels fest
            calculatorDisplay.setSize(50, 50);
            // Legt die Hintergrundfarbe des JLabels fest
            calculatorDisplay.setOpaque(true);
            calculatorDisplay.setBackground(Color.BLACK);
            // Legt die Schriftgröße des JLabels fest
            calculatorDisplay.setFont(calculatorDisplay.getFont().deriveFont(30f));
            // Legt die Schriftfarbe des JLabels fest
            calculatorDisplay.setForeground(Color.WHITE);
            // Legt den Text des JLabels fest
            calculatorDisplay.setText(displayText);
            // Gibt das JLabel zurück
            return calculatorDisplay;
    }