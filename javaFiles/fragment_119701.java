@Database(entities = {AppName.class, People.class}, version = 4, exportSchema = true)
public abstract class SoundguardRoomDatabase extends RoomDatabase {

    ...

    static final Migration MIGRATION_3_4 = new Migration(3, 4) {
            @Override
            public void migrate(SupportSQLiteDatabase database) {
                database.execSQL("CREATE TABLE IF NOT EXISTS `" + TABLE_NAME + "` (`name` TEXT NOT NULL, `priority` INTEGER NOT NULL, PRIMARY KEY(`name`))");
            }
        };