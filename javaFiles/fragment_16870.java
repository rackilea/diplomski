//Declare one variable at top like below
boolean isButtonClicked = false;

   if(clicked == button) 
   {
       button.setIcon(image1);
       isButtonClicked = true;
   }
   else if(clicked == button2)
   {
      if(isButtonClicked) 
      {
           button2.setIcon(image2);
           button1.setIcon(image0);
           isButtonClicked = false;
      }
   }