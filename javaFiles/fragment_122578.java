@Database(entities = arrayOf(Indirizzo::class, Dispositivo::class), version = 1, exportSchema = false)
abstract class WppDb : RoomDatabase() {
    abstract fun DispositivoDao(): DispositivoDao
    abstract fun IndirizzoDao() : IndirizzoDao

    companion object {
        private var INSTANCE : WppDb? =  null

        @JvmStatic
        fun getInstance(context: Context): WppDb? {
            if (INSTANCE == null) {
                synchronized(WppDb::class) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    WppDb::class.java, "weather.db")
                                   .build()
                }
            }
            return INSTANCE
        }

        @JvmStatic
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}