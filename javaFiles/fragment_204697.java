String input = br.readLine();
     showPrimitive(input);  // Note spelling!

     public void showPrimitive(String input) {
         if (input.equalsIgnoreCase("true") ||
             input.equalsIgnoreCase("false")) {
             System.out.println("Primitive : boolean");
             return;
         }
         try {
             long num = Long.parseLong(input);
             if (num >= Byte.MIN_VALUE && 
                 num <= Byte.MAX_VALUE) {
                 System.out.println("Primitive : byte");
             } else if (num >= Short.MIN_VALUE &&
                        num <= Short.MAX_VALUE) {
                System.out.println("Primitive : short");
             } else if (num >= Integer.MIN_VALUE &&
                        num <= Integer.MAX_VALUE) {
                System.out.println("Primitive : int");
             } else {
                System.out.println("Primitive : long");
             }
             return;
         } catch (NumberFormatException ex) {
             // continue
         }
         // deal with floating point (c.f. above)
         // deal with char: input length == 1
         // anything else is a String.
     }