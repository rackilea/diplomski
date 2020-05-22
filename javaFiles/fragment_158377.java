//new SelectSolutionsQuadratic().setVisible(true);//REMOVE THIS LINE
String dataSent = aQuadraticSpinner.getValue().toString() + " " +   
                    addSubQuadraticComboBox.getSelectedItem(); 
SelectSolutionsQuadratic transferMe = new SelectSolutionsQuadratic();
transferMe.displayText(dataSent);
transferMe.setVisible(true);//ADD THIS LINE