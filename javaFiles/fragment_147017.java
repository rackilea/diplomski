private void setExamButtonActionPerformed(java.awt.event.ActionEvent evt)
   {                 
       if(evt.getActionCommand().equals("Set Exam"))
       {
           CardLayout cL = (CardLayout)cardPanels.getLayout();
           cL.show(cardPanels, "setExamPanel");
       }

       try
       {
           String theMessage = myObject.getMessage();          

           String delims = "(?=(0*([0-9]{1,2}|100)))"; 
           String[] questions = theMessage.split(delims);

           for (int j = 1; j < questions.length; j++)
           {
               settingQuestionBox = new JCheckBox(questions[j]);  // *** renamed to make more sense
               settingQuestionBox.setActionCommand(questions[j]);  // **** add actionCommand String
               questionsList.add(settingQuestionBox); // ****** add JCheckBox to List

               settingQuestionTextField = new JTextField("");

               jPanel1.add(settingQuestionBox);              
               jPanel1.add(settingQuestionTextField);
               jPanel1.revalidate();
               jPanel1.repaint();                  

           }

           //close streams and socket code

       }
       catch(Exception e)
       {
           // System.out.println(e);
           e.printStackTrace(); // ***** more informative
       }
   }