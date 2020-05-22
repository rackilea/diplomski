String timeString1="12:34";
   String timeString2="06:31"; 

   String[] fractions1=timeString1.split(":");
   String[] fractions2=timeString2.split(":");
   Integer hours1=Integer.parseInt(fractions1[0]);
   Integer hours2=Integer.parseInt(fractions2[0]);
   Integer minutes1=Integer.parseInt(fractions1[1]);
   Integer minutes2=Integer.parseInt(fractions2[1]);      
   int hourDiff=hours1-hours2;
   int minutesDiff=minutes1-minutes2;
   if (minutesDiff < 0) {
       minutesDiff = 60 + minutesDiff;
       hourDiff--;
   }
   if (hourDiff < 0) {
       hourDiff = 24 + hourDiff ;
   }
   System.out.println("There are " + hourDiff + " and " + minutesDiff + " of difference");