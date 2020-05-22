@Override
        public void actionPerformed(ActionEvent e) {

            // assuming two JTextFields in the app, nameField and idField
            String name = nameField.getText();
            String identification = idField.getText();

            // create new Person with the name and id information
            Person person = new Person(name, identification);

            // create a new PersonAction with the Person above 
            // and pass into a JButton
            JButton personButton = new JButton(new PersonAction(person));

            // assuming a JPanel called personPanel that holds these JButtons
            personPanel.add(personButton);  // add the button 
            personPanel.revalidate();  // tell the panel to relayout components
            personPanel.repaint();  // and repaint
        }