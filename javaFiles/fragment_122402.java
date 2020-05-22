if (messageWordIntArray[r] <=25 ) {
         messageWordIntArray[r] = messageWordIntArray[r] + t;
   } else if (messageWordIntArray[r] == 26 && t>0) {
         messageWordIntArray[r] = 0;
         messageWordIntArray[r] = messageWordIntArray[r] + t;
   }