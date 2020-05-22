public JTextArea txtArea() {
    JTextArea area = new JTextArea();
    CustomFocusListener cFL = new CustomFocusListener();
    area.addFocusListener(cFL);
    String st = String.valueOf(tab);
    area.setName(st);

     return area;
}