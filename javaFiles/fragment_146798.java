Realm.init(this);

RealmConfiguration mRealmConfiguration = new RealmConfiguration.Builder()
                .name("yourDBName.realm")
                .schemaVersion(1) // skip if you are not managing
                .deleteRealmIfMigrationNeeded()
                .build();

Realm.getInstance(mRealmConfiguration);
Realm.setDefaultConfiguration(mRealmConfiguration); // add this line in your configuration