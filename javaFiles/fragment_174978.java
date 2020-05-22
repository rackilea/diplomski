public class RealModule {
    /** provider only needed if HttpClient has no default no-args public constructor */
    @Provides HttpClient getClient() {
        return HttpClient.getNewInstance().customize();
    }
}