public Test(Dimension d) {

    int w = (int) (Math.round(d.getWidth()) / 2);
    int h = (int) (Math.round(d.getHeight()) / 2);
    setPreferredSize(new Dimension(w, h));

    initComponents();

    setLocationRelativeTo(null);
    bUpdate.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            cargarProductos();
        }
    });

    this.addComponentListener(new ComponentAdapter() {
         @Override
         public void componentResized(ComponentEvent e) {
             cargarProductos();
         }
    });
}