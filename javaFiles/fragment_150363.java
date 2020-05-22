for (int row = 0; row<7; row++) {
    for (int col = 0; col<10; col++) {
        JButton b = new JButton();
        frame.getContentPane().add(b, "cell "+ col +" "+ row +",grow");
    }
}