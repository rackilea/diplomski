// Pseudo code
public static class RealmHelper {
    private static SharedPreferences prefs;
    public static Realm getInstance(Context context) {
        String realmPath = new File(context.getFilesDir(), "default.realm").getAbsolutePath();
        if (prefs.getBoolean("firstRun", true)) {
            Realm.migrateRealmAtPath(realmPath, new RealmMigration() {
                @Override
                public long migrate(Realm realm, long oldVersion) {
                    return 42; // new version of Realm
                }
            });
            prefs.edit().putBoolean("firstRun", false).commit();
        }

        try {
            return Realm.getInstance(context);
        } catch (RealmMigrationNeededException e) {
            Realm.migrateRealmAtPath(realmPath, new CustomMigration());
            return Realm.getInstance(context);
        }
    }
}