JTextArea ta = new JTextArea(20, 20);
switch (JOptionPane.showConfirmDialog(null, new JScrollPane(ta))) {
    case JOptionPane.OK_OPTION:
        System.out.println(ta.getText());
        break;
}