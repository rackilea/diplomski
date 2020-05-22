Map<String,Boolean> map = new HashMap<String,Boolean>();
for(int i=0;i<userProductData.size();i++){
    String productSubCategoryName=userProductData.get(i).getProductSubCategory();
    System.out.println(productSubCategoryName);
    map.put(productSubCategoryName, true);
}
request.setAttribute("productSubCategoryMap", map);