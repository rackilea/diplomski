public void actionPerformed(ActionEvent arg0) {
    frame.removeAll();
    frame.revalidate();
    frame.repaint();
    frame.add(button2);
    System.out.println("This is performed, but the button doesnt change");
}