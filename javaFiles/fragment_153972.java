JSONObject jsonObj = new JSONObject(response);

 String fromCurrency = jsonObj.getString("from");
 String toCurrency= jsonObj.getJSONObject("to");
 Double fromAmount = jsonObj.getDouble("from_amount");
 Double toAmount= jsonObj.getDouble("to_amount");