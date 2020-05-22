if(donationType>2)
     {
         if(donationType == CLOTHING_CODE)
         {
            volunteer = CLOTHING_PRICER;
            message = "a clothing donation";
         }
         else
         {
            volunteer = OTHER_PRICER;
            message = "a non-clothing donation";
         }
    } 
     else
    {
         message = "This is an invalid donation type";
         message = "The volunteer who will price this item is invalid";
     }