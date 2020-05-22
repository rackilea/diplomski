public boolean validated() {

  boolean ok = true;

  if (quantity < 0)
     {
        System.out.println("Quantity is negative. Cannot compute 
                             discount");
        ok = false;
     }

  if (price< 0)
     {
        System.out.println("Price is negative. Cannot compute 
                            discount");
        ok = false;
     }

   return ok;