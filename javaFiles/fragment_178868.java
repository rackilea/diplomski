public void actionPerformed(ActionEvent arg0) {
            try{
                min = Integer.parseInt(textField.getText());
                max = Integer.parseInt(textField_1.getText());                  
                int broj = generisanje.glavno(guiObject.min, guiObject.max);
                String brString = Integer.toString(broj);
                textField_2.setText(brString);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }