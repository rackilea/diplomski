public void actionPerformed(ActionEvent e) {
    JPanel jPSouth = new JPanel();
    jPSouth.setBackground(Color.YELLOW);
    jlp.add(jPSouth, BorderLayout.SOUTH, JLayeredPane.DEFAULT_LAYER);
    //Need these to here!
    jlp.repaint();
    jlp.revalidate();
    System.out.println("enter");
}