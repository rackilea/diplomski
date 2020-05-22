public void actionPerformed(ActionEvent e) {
            String text = textArea.getText();
            Profile profile = service.getProfile(text).execute();  
            System.out.println(profile);


                }