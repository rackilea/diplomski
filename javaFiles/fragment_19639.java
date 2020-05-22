RealmQuery realmQuery = RealmResults<Products>.where();
String[] split = String.valueOf(constraint).split(" ");
for(String part : split) {
    realmQuery = realmQuery.contains("ProductDescription", part, Case.INSENSITIVE);
}
return realmQuery.findAll();