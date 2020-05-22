knopOptel.addActionListener((ActionEvent e) ->
    {
        String invoer = invoerVak.getText();
        int invoerGetal = Integer.parseInt(invoer);
        rekenmachine.addition(invoerGetal);
        invoerVak.setText("");
    });