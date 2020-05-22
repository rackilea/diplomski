public void setVyplata(Otec otec) {

    try {
        otec.setVyplata(Integer.parseInt(textField1.getText()));

    } catch (NumberFormatException e) {

        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(panel, "Nemozno vlozit string", "Error", JOptionPane.ERROR_MESSAGE);
            otec.setVyplata(0);
            textField1.setText("0");
        });

    }

}

public void setVyplata(Mama mama) {

    try {
        mama.setVyplata(Integer.parseInt(textField2.getText()));

    } catch (NumberFormatException e) {

        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(panel, "Nemozno vlozit string", "Error", JOptionPane.ERROR_MESSAGE);
            mama.setVyplata(0);
            textField2.setText("0");
        });
    }
}