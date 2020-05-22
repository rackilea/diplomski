protected Void doInBackground(Void... params) {
    Realm realm = Realm.getDefaultInstance();
    try {
        // ... Use the Realm instance ...
    } finally {
        realm.close();
    }

    return null;
}