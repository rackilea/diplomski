public class NamePrice {

   private String[] clothingNames;
   private double[] price; //You used Double which is the object wrapper, either way works
   //This map maps the clothing name to price
   private Map<String, double> nameToPrice;
   //This map maps the price to the clothing name
   private Map<double, String> priceToName;

   public NamePrice(String[] cN, double[] p){

      //Takes the input and set it to the private variables
      clothingNames = cN;
      price = p;

      //Then we construct or map
      nameToPrice = new HashMap<String, double>();
      priceToName = new HashMap<double, String>();
      //Put everthing we have into the maps
      for(int i = 0; i < clothingNames.length && i < price.length; i++){
         nameToPrice.put(clothingNames[i], price[i]);
         priceToName.put(price[i], clothingNames[i]);
      }

      //Then we sort the arrays
      Arrays.sort(clothingNames);
      Arrays.sort(price);

   }



}