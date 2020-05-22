public void actionPerformed(ActionEvent e)
            {

              houseNumber2 = houseNumber1.getText();
              housePrice2 = housePrice1.getText();
              town1 = town.getText();
              comboBoxType2 = comboBoxType1.getSelectedItem();


            inputData = housenumber2 + "," + housePrice2 + "," + town1 + "," + comboBoxType2;
             FileName.Filewritermethod(inputData);
             frame.setVisible(false);

            }
       });