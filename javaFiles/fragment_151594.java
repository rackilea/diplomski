String longestYet= "";
 for (Enum<?> value :OfferType.values()){
     if (longestYet.length()< value.name().length()) {
        longestYet= value.name();   
     }                
 }
 longest = longestYet;