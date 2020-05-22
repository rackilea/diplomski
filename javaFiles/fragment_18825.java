... 
...
// THE VALUE OBJECT REFERENCE WITH THE VALUES YOU NEED TO HOLD DURING THE FORM INTERACTION
private CalculatedValues calculatedValues;

WellParameters() {  
    super("Well Parameters", true, true, false, true);
    this.setBounds(0, 0, 600, 385);
    this.setVisible(true);
    this.setLayout(new BorderLayout());

    ...//GUI Stuff

    this.add(submitButtonPanel, BorderLayout.SOUTH);

    // THE VALUE OBJECT REFERENCE...
    calculatedValues = CalculatedValues.makeNew();
}