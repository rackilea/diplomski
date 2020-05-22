private static void submitOffer() throws OfferException{

 // ...
 if ( sales[i].getSaleID().equalsIgnoreCase(saleID)){   

    //try {  Remove this try
    offerAccepted = sales[i].makeOffer(offerPrice);
    if (offerAccepted == true){
       System.out.print("Offer was accepted"); 
       if(offerPrice <= sales[i].getReservePrice()){
             System.out.print("Reserve Price was met");
       }else{
          throw new OfferException("Resever not met!");
       }
    }else{
       throw new OfferException("Offer was Not accepted");
    }

    //....

}