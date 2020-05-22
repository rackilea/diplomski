private void deleteFromDatabase(final String itemName) {
    realm.executeTransactionAsync(new Realm.Transaction() {
        @Override
        public void execute(Realm bgRealm) {
            Item item = bgRealm.where(Item.class).equalTo("name", itemName).findFirst();
            if(item != null) {
                item.deleteFromRealm();
            }
        }
    }, new Realm.Transaction.OnSuccess() {
        @Override
        public void onSuccess() {
            // Transaction was a success.
            Log.v("database", "Delete ok");
        }
    }, new Realm.Transaction.OnError() {
        @Override
        public void onError(Throwable error) {
            // Transaction failed and was automatically canceled.
            Log.e("database", error.getMessage());
        }
    });

}