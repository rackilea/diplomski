private void nextActionPerformed(java.awt.event.ActionEvent evt) {                                     

        String value=(String)select.getSelectedItem(); 
        System.out.println(value); // example you get abc
        if("abc".equals(value)){  // change to abc

            ImageCrypto im=new ImageCrypto();
            im.setVisible(true);
            this.dispose();

        }else if("text file".equals(value)){
            TextCrypto im=new TextCrypto();
            im.setVisible(true);
            this.dispose();
        }

    }