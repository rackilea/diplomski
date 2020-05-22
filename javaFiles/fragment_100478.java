btnWeiter4.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent arg0) {


                JLabel loading = new JLabel("loading ...\r\n");
                loading.setBounds(1087, 599, 121, 45);
                loading.setIcon(new ImageIcon("ajax-loader.gif")); // Check whether the gif file is really in the root folder 
                loading.setVisible(true); // show loading image
        String currentTime    = String.valueOf(System.currentTimeMillis());
System.out.println("Im done with JPanel " + currentTime);
                panel_4.add(loading);               

                SendEmail email = new SendEmail();
                email.send();   // sends email
    String currentTime2    = String.valueOf(System.currentTimeMillis());
System.out.println("Im done with Email sending " + currentTime2);

              }
          });