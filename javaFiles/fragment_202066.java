public Shoplist createShoplist(String title) {

     realm = Realm.getDefaultInstance();
     realm.beginTransaction();

     Shoplist shoplist = realm.createObject(Shoplist.class)
     shoplist.setTitle(title);

     realm.copyToRealm(shoplist);
     realm.commitTransaction();

     return shoplist;
}