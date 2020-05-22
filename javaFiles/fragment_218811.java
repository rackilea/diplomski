class RequestDataHolder {
   // this is not thread safe since multiple threads access the same data
   public static String customer_id;

   public static void setLogParams(String company_id, String userId){
      RequestDataHolder.customer_id = customer_id;
   }
}