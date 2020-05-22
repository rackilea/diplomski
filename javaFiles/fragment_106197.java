DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.US);
    DecimalFormat strictFormat = new StrictDecimalFormat();
    strictFormat.setDecimalFormatSymbols(decimalFormatSymbols);

    JDialog dialog = new JDialog();
    JPanel panel = new JPanel(new BorderLayout());
    dialog.getContentPane().add(panel);

    JFormattedTextField textField = new JFormattedTextField(strictFormat);
    textField.setText("1,23");
    panel.add(textField, BorderLayout.CENTER);
    panel.add(new JButton("focus"), BorderLayout.EAST);

    dialog.pack();
    dialog.setVisible(true);