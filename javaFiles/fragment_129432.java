for(int i = 0; i < myMenu.drinks.size(); i++){
    HashMap<String,String> hm = new HashMap<String, String>();
    hm.put("Name",myMenu.drinks.get(i).drinkName);
    hm.put("Price",myMenu.drinks.get(i).drinkPrice.toString());
    aList.add(hm);
}

String[] from = {"Name","Price"}; //changed from {"drinkName","drinkPrice"}