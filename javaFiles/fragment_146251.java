Map<String, Merchant> favoriteMerchantMap = new HashMap<>();
for (Merchant favoriteMerchant : favoriteMerchantsList) {
    favoriteMerchantMap.put(favoriteMerchant.getId(), favoriteMerchant));
}
for (Merchant storeMerchant : storeMerchantList) {
    Merchant favoriteMerchant = favoriteMerchantMap.get(storeMerchant.getId());
    if (favoriteMerchant != null) {
             ....
    }