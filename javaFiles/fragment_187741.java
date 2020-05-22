if (radioQ == "yes")//use equalsIgnoreCase method of String
   System.out.print("With the radio discount, you will save 20%!");
   radioT = ((ticketTotal - (ticketTotal * radioDiscount)));
   if (radioT >= 200 && radioT < 400)
       System.out.println("With a 10% discount, your total is: $"
        + (radioT * .9));
   else if (radioT > 400)
       System.out.println("With a 15% discount, your total is: $"
         + (radioT * .85));
   //apply discount on ticket total?
} else ...