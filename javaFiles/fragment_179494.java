//assuming you are passing `lots` as parameter
    public List<Lot> getUnsold(List<Lot> lots)
    {  
       List<Lot> unsold = new ArrayList<Lot>();
       for(Lot lot : lots) 
       {
        Bid highestBid = lot.getHighestBid();
        lotNumber = lot.getNumber();
          if (highestBid != null) 
            {

                System.out.println("Lot number " + lotNumber + " is sold"); //retuern "Sold" is highestBid
            }
          else
            {
                System.out.println(lotNumber); //print bidder and highest bid value
                unsold.add(lot); // you are missing this
            }
       }
       return unsold;
    }