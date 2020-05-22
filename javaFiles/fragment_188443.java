private static String getDateWithMaxValue(JSONArray array) throws JSONException {
   JSONArray stockData;
   String dateWithMaxValue = "";
   double maxValue = Double.MIN_VALUE;
   for (int i = 0; i < array.length(); i++) {
      stockData = array.getJSONArray(i);
      if (stockData.get(1) instanceof Double) {
         if (((Double) stockData.get(1)).doubleValue() > maxValue) {
            maxValue = ((Double) stockData.get(1)).doubleValue();
            if (stockData.get(0) instanceof String) {
               dateWithMaxValue = (String) stockData.get(0);
            }
         }
      }
   }
   return dateWithMaxValue;
}