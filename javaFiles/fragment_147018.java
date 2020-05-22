setExamQuestionButtonActionPerformed(java.awt.event.ActionEvent evt)
  {
     if(evt.getActionCommand().equals("Set Exam Question"))
     {           
        // ArrayList<JToggleButton> settingQuestionBoxes = new ArrayList<JToggleButton>();

        for(JToggleButton questions: questionsList)
        {               
            if(questions.isSelected())
            {               
                System.out.println(questions.getActionCommand());
            }
        }           

        CardLayout cL = (CardLayout)cardPanels.getLayout();
        cL.show(cardPanels, "instructorPanel");
      }
  }