for (int i = 0; i < 20; i++) {
    JLabel lbl = new JLabel("AAAA ");
    lbl.setOpaque(true);
    lbl.setBorder(BorderFactory.createLineBorder(Color.black, 1));
    tp.insertComponent(lbl);
    doc.insertString(doc.getLength(), " ", null);
    tp.setCaretPosition(doc.getLength());
}