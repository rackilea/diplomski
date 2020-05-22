public static void main(String[] args) {
    JFrame frame = new JFrame("Test");

    final JSplitPane split = new JSplitPane(
            JSplitPane.HORIZONTAL_SPLIT, 
            new JLabel("first"), 
            new JLabel("second"));

    frame.add(split, BorderLayout.CENTER);
    frame.add(new JButton(new AbstractAction("Swap") {
        @Override
        public void actionPerformed(ActionEvent e) {
            // get the state of the devider
            int location = split.getDividerLocation();

            // do the swap
            swap(split);

            // update the devider 
            split.setDividerLocation(split.getWidth() - location 
                    - split.getDividerSize());
        }


    }), BorderLayout.SOUTH);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setVisible(true);
}