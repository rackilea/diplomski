public static void main(String[] args) {
    final JFrame jf = new JFrame();
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    final Grid grid = new Grid();
    jf.add(grid);
    jf.pack();
    jf.addWindowListener(new WindowAdapter() {
        public void windowActivated(WindowEvent e) {
            int i = 0;
            Component[] components = grid.getComponents();
            for (Component component : components) {
                i++;
                Color color = component.getBackground();
                Rectangle bounds = component.getBounds();
                System.out.println("box " + i + ",coordinate= " + bounds
                        + ", Color= " + color);
            }
        }
    });
    jf.setVisible(true);
}