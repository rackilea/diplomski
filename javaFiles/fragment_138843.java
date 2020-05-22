public void actionPerformed(ActionEvent e) {
    System.out.println(e);
    name.getText();
    pass.getText();

    name.setText("");
    pass.setText("");

    repaint();
    revalidate();
}