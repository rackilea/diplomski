protected void onPostExecute(String result) {
    List<ShopInfo> list = new ArrayList<ShopInfo>();
    for (int i = 0; i < shopList.size(); i++) {
        ShopInfo ci = new ShopInfo();
        HashMap<String, String> map = shopList.get(i)
        ci.name =    map.get(TAG_NAME);
        ci.address = map.get(TAG_ADDRESS);
        list.add(ci);
    }

    ShopAdapter ca = new ShopAdapter(list);
    recList.setAdapter(ca);
}