while (x<=trace)
    {
      System.out.println("Year"+year+":");
      System.out.println("Effective interest rate "+effective_interest+"%");
      System.out.println("Amount gained "+amount_gained);
      System.out.println("Amount at the end of the year "+(yearly_amount));
      System.out.println("");
      original_amount+=amount_gained;
      x++;
      year++;
    }