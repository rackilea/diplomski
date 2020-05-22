@Provides 
@Singleton 
fun provideDatabase(@AppContext context: App): Database<@JvmWildcard Realm> {
    Realm.init(context)
    val config = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .name("db")
            .build()
    Realm.setDefaultConfiguration(config)
    return RealmDatabase(Realm.getDefaultInstance())
}