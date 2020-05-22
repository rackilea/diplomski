ArrayList<JLabel> VariableLabelList =new ArrayList<JLable>();
ArrayList<JCheckBox> isIntervalList =new ArrayList<JCheckBox>();
ArrayList<JTextField> VariableValueList =new ArrayList<JTextField>();
ArrayList<JTextField> VariablePlusMinusList =new ArrayList<JTextField>();
for(int i = 0; i < VariableAmount; i++) {
                    JLabel VariableLabel = new JLabel(VariableList.get(i) + "     =");
                    springLayout.putConstraint(SpringLayout.NORTH, VariableLabel, 30 * i + 10, SpringLayout.NORTH, frame.getContentPane());
                    springLayout.putConstraint(SpringLayout.WEST, VariableLabel, 10, SpringLayout.WEST, frame.getContentPane());
                    springLayout.putConstraint(SpringLayout.EAST, VariableLabel, 50, SpringLayout.WEST, frame.getContentPane());
                    frame.getContentPane().add(VariableLabel);
                    VariableLabelList.add(VariableLabel);

                    JCheckBox isInterval = new JCheckBox("Interval");
                    springLayout.putConstraint(SpringLayout.NORTH, isInterval, 30 * i + 7, SpringLayout.NORTH, frame.getContentPane());
                    springLayout.putConstraint(SpringLayout.EAST, isInterval, -10, SpringLayout.EAST, frame.getContentPane());
                    springLayout.putConstraint(SpringLayout.WEST, isInterval, -80, SpringLayout.EAST, frame.getContentPane());
                    frame.getContentPane().add(isInterval);
                    isIntervalList.add(isInterval);

                    VariableValue = new JTextField();
                    springLayout.putConstraint(SpringLayout.NORTH, VariableValue, 30 * i + 10, SpringLayout.NORTH, frame.getContentPane());
                    springLayout.putConstraint(SpringLayout.WEST, VariableValue, 10, SpringLayout.EAST, VariableLabel);
                    springLayout.putConstraint(SpringLayout.EAST, VariableValue, -250, SpringLayout.EAST, frame.getContentPane());
                    frame.getContentPane().add(VariableValue);
                    VariableValue.setColumns(10);
                    VariableValueList.add(VariableValue);

                    VariablePlusMinus = new JTextField();
                    springLayout.putConstraint(SpringLayout.NORTH, VariableValue, 30 * i + 10, SpringLayout.NORTH, frame.getContentPane());
                    springLayout.putConstraint(SpringLayout.WEST, VariableValue, 10, SpringLayout.EAST, VariableValue);
                    springLayout.putConstraint(SpringLayout.EAST, VariableValue, -90, SpringLayout.EAST, frame.getContentPane());
                    frame.getContentPane().add(VariableValue);
                    VariableValue.setColumns(10);
                    VariablePlusMinusList.add(VariablePlusMinus);
}