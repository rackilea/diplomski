showWindowMenu.addItemListener(new ItemListener() {
    public void itemStateChanged(ItemEvent e) {
        if (showWindowMenu.getState()) {
            System.out.println(showWindowMenu.getState());
            menuBar.add(CutMenu);
        } else {
            System.out.println(showWindowMenu.getState());
            menuBar.remove(CutMenu);
        }

        // ************** add this ****************
        menuBar.revalidate();
        menuBar.repaint();
    }
});