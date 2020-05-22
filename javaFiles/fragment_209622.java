searchButton.addActionListener(new ActionListener() {      
 public void actionPerformed(ActionEvent event)  {
           try {
            callUrl();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
      }
   });