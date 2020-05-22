private void initialize() {
    [...]
    GridBagLayout gridBagLayout = new GridBagLayout();
    //gridBagLayout.columnWidths = new int[]{0, 0};
    //gridBagLayout.rowHeights = new int[]{0, 0};
    //gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
    //gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};

    [...]

    JLabel label;
    int i = 0;
    int j = 0;

    for (int[] arr: level1) {
        grid.gridy = i;
        j = 0; // !!!!!!!!!!!!!!!
        for (int elem: arr) {
            if(elem == 1){
                label = new JLabel("x");
            }
            else {
                label = new JLabel(" ");
            }
            grid.gridx = j;
            frame.getContentPane().add(label, grid);
            j++;
        }
        i++;
    }
}