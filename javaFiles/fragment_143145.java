//textfield
id = new JTextField(7);// accepts up to 7 characters    

//buttons
go = new JButton("Go");
go.setBounds(100, 150, 140, 40);
CL = new JButton("Cheap Lock");
CL.setBounds(100,300,140,40);

//JLabel that shows button has stored the input
go1 = new JLabel();
go1.setBounds(10, 160, 200, 100);


//button action listener
go.addActionListener(new ActionListener() {          
        @Override
        public void actionPerformed(ActionEvent arg0) {
                go1.setText("Student ID has been submitted.");
                String value = id.getText();
                // logic here - e.g. Integer.parseInt();            
        }          
});