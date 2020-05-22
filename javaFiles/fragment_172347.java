public void changeRadioState(List<WebElement> radioButtons){        
   for(WebElement radioButton: radioButtons)
   {
       if (!radioButton.isSelected()){              
          radioButton.click();
          break;
       }
   }
}