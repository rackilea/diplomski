// Section (A)
ArrayList<JToggleButton> settingQuestionButton = new ArrayList<JToggleButton>();

// Section (B)
for(JToggleButton questions: settingQuestionButon)  
{               
    if(questions.isSelected())
    {               
        System.out.println(questions.getActionCommand());
    }
}