public static enum MyType {

    NORMAL,
    OTHER;

   public static final String longest; 
   static{
        String longestYet= "";
        for (Enum<?> value :MyType.values()){
           if (longestYet.length()< value.name().length()) {
            longestYet= value.name();   
           }                
        }
        longest = longestYet;
    }        
}