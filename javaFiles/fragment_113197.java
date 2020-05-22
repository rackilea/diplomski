public void actionPerformed(ActionEvent ae)
    {
        String fontvalue = (String) font.getSelectedItem();
        int stylevalue = 0;
        int sizevalue = (Integer) size.getSelectedItem();

        if(style.getSelectedItem().equals("Bold"))
        {
            stylevalue = Font.BOLD;
        }
        else if(style.getSelectedItem().equals("Italic"))
        {
            stylevalue = Font.ITALIC;
        }
        else if(style.getSelectedItem().equals("Bold and Italic"))
        {
            stylevalue = Font.BOLD|Font.ITALIC;
        }
        else
        {
            stylevalue = Font.PLAIN;
        }
        Font areafont = new Font(fontvalue,stylevalue,sizevalue);
        //area.setFont(areafont);
        dialog.dispose();        
    }