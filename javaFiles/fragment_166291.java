List<String> carts = findRexExpList(cartItemParameter, "\\D+\\d+");
String[] cartPrices = request.getParameter("cartprice").split(",");
for(int i=0; i<cartPrices.length; i++){
   String cart = carts.get(i);
   String price = cartPrices[i];
   //insert cart and price
}