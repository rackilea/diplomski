public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setSize(500, 500);
    JPanel panel = new JPanel();
    panel.setSize(500, 500);
    frame.add(panel);
    frame.show();
    run(panel);
}

 public static void run(JPanel panel){
        panel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e){
                JButton button = new JButton();
                button.setVisible(true);                 
                panel.add(button);
                panel.revalidate();
            }
       });
}