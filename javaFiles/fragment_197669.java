RealmConfiguration config = new RealmConfiguration.Builder(getContext()).
        schemaVersion(1).
        migration(new CustomMigration()).
        name("test.realm").
        inMemory().
        build();
Realm.setDefaultConfiguration(config);