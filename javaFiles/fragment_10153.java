for (int button = 0 ; button <= ListofJButtons.size() - 1; button++) {
    final int index = button;
    ListofJButtons.get(button).addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // Because index is final I can access it here and know the index
            System.out.println("I clicked on button "+index+"!");
            JButton buttonSource = (JButton) e.getSource();
            System.out.println( " sourceButton " + buttonSource.getIndex()); //is there any method like that in Java?
        }
    } );
}//for loop