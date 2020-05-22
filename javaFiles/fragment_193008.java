public void actionPerformed(ActionEvent e) {

        ImageIcon imageresult = null;
        if(R==1726)
        {
            yourphone = "Samsung Galaxy S4\r\nHTC One\r\nSony Xperia Z";
            imageresult = new ImageIcon("galaxy_one_XperiaZ.jpg");
        }
        else if(R==5002)
        {
            yourphone = "Sony Xperia Z1\r\nSamsung Galaxy Note 3";
            imageresult = new ImageIcon("Note3_sonyZ1.jpg");
        }
        else
        {
            yourphone = "No Results";
        }

        resultlabel.setIcon(imageresult)
        txtrphoneresult.setText(yourphone);

 }