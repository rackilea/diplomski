public InputPanel() {

    JPanel topPanel = new JPanel(); // Create a new panel
    topPanel.setLayout(FlowLayout()); //Left to right alignment is default for FlowLayout

    //Add your textfield and buttons to the panel with flowlayout
    tfield = new TextField("Search your terms here!");  
    topPanel.add(tfield);

    searchButton = new JButton("Search");
    searchButton.addActionListener(this);
    topPanel.add(searchButton);

    clearButton = new JButton("Clear Text");
    clearButton.addActionListener(this);
    topPanel.add(clearButton);

    add(topPanel, BorderLayout.NORTH); // Add the panel containing the buttons and textfield in the north

    resultsArea = new TextArea();
    add(resultsArea, BorderLayout.CENTER); //Add the textarea in the Center

}