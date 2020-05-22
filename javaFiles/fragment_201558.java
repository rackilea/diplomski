public static ArrayList<Item> getProductsByCategory(String category, ArrayList<Item> productList) {

    ArrayList<Item> returnList = new ArrayList<>();

    for (int i = 0; i < productList.size(); i++) {

        if (category.equals(productList.get(i).getmProductType())) {
            returnList.add(productList.get(i));
        }

    }
    return returnList;
}