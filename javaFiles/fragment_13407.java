public String generateCustomerID(String id, int digit)
{
   randomGenerator = new Random();
   String index = "";
   for(int i = 1; i <= digit; i++) {
        index += randomGenerator.nextInt(10); //Generate a value between 0 and 9 (inclusive)
   }

   return id + index;
}