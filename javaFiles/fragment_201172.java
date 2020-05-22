public void actionPerformed(ActionEvent e) {
    LayoutManager tempGroupLayout = jPanel1.getLayout();
    jPanel1.setLayout(layoutManager2);
    getContentPane().validate();  // <= added line
    layoutManager = layoutManager2;
    layoutManager2 = tempGroupLayout;
}