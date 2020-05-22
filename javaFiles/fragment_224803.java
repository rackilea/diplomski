//constructor
public EmployeeFrameView()
    {
       super("AddEmployee",true,true,true,true);
       getContentPane.setLayout(new BorderLayout());
       addComponentsToPane(getContentPane());
       pack();
       setVisible(true);
       setLocation(xOffset,yOffset);
    }

//method
public void addComponentsToPane(Container pane) {
    JPanel content = new JPanel();
    content.setLayout(new BorderLayout());
    panelEmployee = new JPanel();
    panelEmergency = new JPanel();

    content.add(addComponentsToEmployeePanel(panelEmployee), BorderLayout.NORTH);
    content.add(addComponentsToEmergencyPanel(panelEmergency), BorderLayout.CENTER);
    JScrollPane scrollPane = new JScrollPane(content, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

    pane.add(scrollPane);
}