@Module(includes = arrayOf(NetworkModule::class))
class RetrofitApiModule() {
    @Provides
    @Singleton
    fun provideMvpApi(val retrofitMvpApi: RetrofitMvpApi): MvpApi {
        return retrofitMvpApi
    }
}