String action = scanner.next();
if (action.equals("bye")) {
   ...
} else if (action.equals("add")) {
   if (scanner.hasNextInt()) {
     int num1 = scanner.nextInt();
     if (scanner.hasNextInt()) {
        /* ADD NUM1 NUMN+ TOGETHER */
        int total = num1;
        System.out.print("" + num1);
        while (/* has more int */) {
           int numN = /* read int */
           System.out.print(" + " + numN);
           /* increase total */
        }
        /* display results */
        /* now expecting "together" */
     } else {
       /* ADD NUM TO NUM */
       if (!scanner.hasNext()
           || !scanner.next().equals("to")) {
         /* expecting "to" */
       } else {
         /* get next number, add, show results */
       }
     }
   } else {
      /* expecting NUM */
   }
} else ...