public ArrayList<String> getAllChoices(String[] flavors, String[] toppings) {
    ArrayList<String> tempList = new ArrayList<>();
    for (int i = 0; i < flavors.length; i++) {
        for (int x = 0; x < toppings.length; x++) {
            String temp = flavors[i] + " with " + toppings[i] + " on top";
            tempList.add(temp);
        }
    }
    return tempList;
}