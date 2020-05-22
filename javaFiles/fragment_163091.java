while (scn.hasNext()) {

     String productName = scn.next();

     if ( scn.hasNext() ) {

       double productPrice = scn.nextDouble();

       if ( scn.hasNext() ) {

         int productAmount = scn.nextInt();

         // Do something with the three values read...

       } else {
         // Premature end of file(?)
       }

     } else {
         // Premature end of file(?)
     }

   }