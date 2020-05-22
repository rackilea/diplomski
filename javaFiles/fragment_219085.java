for (int i=0; i < 9; i++) {
    // You cannot access i from methods of the anonymous inner class
    // because it is not final, but you can make a final copy
    final int iCopy = i;
    JMenuItem blockName = new JMenuItem(i+"");
    blockName.addActionListener(new ActionListener() {
        // It is OK to define additional methods here:
        public void action() {
            System.out.println(iCopy+"");
        }
        public void actionPerformed(ActionEvent arg0) {
            action();
        }
    });
    blocks.add(blockName);
}