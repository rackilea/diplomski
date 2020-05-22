public int compareTo(Telephone d){
    int cc1 = this.getCountryCode();
    int cc2 = d.getCountryCode();

    if(cc1 == cc2){
      double price1 = this.getPrice();
      double price2 = d.getPrice();          
      if(price1 < price2)
         return -1;
      if(price1 > price2)
         return 1;
      return 0;
    }

    return cc1 - cc2;    
 }