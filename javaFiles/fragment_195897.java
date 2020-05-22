public JTextArea txtArea() {
    JTextArea area = new JTextArea();
    tstDocumentListener dcL = new tstDocumentListener();
    area.getDocument().addDocumentListener(dcL);
    String st = String.valueOf(tab);
    area.setName(st);

    return area;
}