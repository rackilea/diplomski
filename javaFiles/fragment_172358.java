public class Migration implements RealmMigration {
    @Override
    public void migrate(final DynamicRealm realm, long oldVersion, long newVersion) {
        RealmSchema schema = realm.getSchema();
        // Migrate from version 0 to version 1
        if (oldVersion == 0) {
            RealmObjectSchema entriesSchema = schema.get("Entries");
            RealmObjectSchema entrySchema = schema.get("Entry");

            entrySchema.addField("date", Date.class);

            Calendar calendar = Calendar.getInstance();
            RealmResults<DynamicRealmObject> entriesList = realm.where("Entries").findAll();
            for (DynamicRealmObject entries : entriesList) {
                RealmList<DynamicRealmObject> entryList = entry.getList("entries");
                for (DynamicRealmObject entry : entryList) {
                    Date date = entries.getDate("date");
                    calendar.setTime(date);
                    calendar.set(Calendar.HOUR_OF_DAY, entry.getInt("hours"));
                    calendar.set(Calendar.MINUTES, entry.getInt("minutes");
                    entry.setDate("date", calendar.getTime());
                }
            }
            entrySchema.removeField("hours");
            entrySchema.removeField("minutes");
            oldVersion++;
        }
    }

    // hashCode, equals
}