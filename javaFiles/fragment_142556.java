public void createElevatorButtons(final CustomPanel panel) {
    ArrayList<JButton> buttons = new ArrayList<>(); //arraylist of buttons we can keep track of
    JPanel buttonPanel = new JPanel(); //the visible component
    for(int i = 1; i <= numberOfFloors;i++) {
        JButton button = new JButton(String.valueOf(i)); //creates buttons for floors 1 to max
        buttons.add(button);
        buttonPanel.add(button);
    }
    panel.add(buttonPanel);

    //add the action listeners
    for(JButton button : buttons) {
        button.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton floor = (JButton) e.getSource();
                int floorNumber = Integer.parseInt(floor.getText());
                panel.foo(floorNumber); //we tell the elevator/panel/whatever to do something, you will have to extend JPanel to do foo
            }
        });
    }
}