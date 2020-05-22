for (int i=0; i<jsonArr.length(); i++) {
    JSONObject jsonDrink = jsonArr.getJSONObject(i);
    String alcohol = jsonDrink.getString("alcohol");
    String date = jsonDrink.getString("date");
    double units = jsonDrink.getDouble("units");
    Drink drink = new Drink();
    // initialize drink object values here or in constructor (don't know what this class has)
    drinks.add(drink);
}