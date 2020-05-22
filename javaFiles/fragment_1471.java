/**
* Function store order details
**/
public JSONObject orderDetails(String username, String[] pid, String[] products,    String[] quantity, String[] totalprice, String finalprice) {
// Building Parameters
List params = new ArrayList();
params.add(new BasicNameValuePair("tag", order_tag));
params.add(new BasicNameValuePair("username", username));
params.add(new BasicNameValuePair("finalpice", finalprice));
for (int i = 0; i < pid.length; i++) {
    params.add(new BasicNameValuePair("pid[]", pid[i]));
}   
for (int j = 0; j < products.length; j++) {
    params.add(new BasicNameValuePair("products[]", products[j]));
}
for (int k = 0; k < quantity.length; k++) {
    params.add(new BasicNameValuePair("quantity[]", quantity[k]));
}
for (int l = 0; l < totalprice.length; l++) {
    params.add(new BasicNameValuePair("totalprice[]", totalprice[l]));
}

JSONObject json = jsonParser.getJSONFromUrl(orderURL,params);
return json;
}