public void actionPerformed(ActionEvent e) {
    String txt = textArea.getText();
    String txt2 = search.getText();
    String txt3 = replace.getText();

    if (txt.toLowerCase().contains(txt2.toLowerCase())) {
            textArea.setText(txt.replaceAll("(?i)" + txt2, txt3));

    }
}