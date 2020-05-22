if(frequency <= 31) {
   // Group 1
 } else if (frequency <= 62) {
   // Group 2
 } else if (frequency <= 124) {
   // Group 3
   if(frequency >= 62 && frequency <= 65)
   {
       note.setText("C");
   }
   else if(frequency >= 70 && frequency <= 74)
   {
       note.setText("C#");
   }
   else if(frequency >= 77 && frequency <= 81)
   {
       note.setText("D");
   }
 } etc etc