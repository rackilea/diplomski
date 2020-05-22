public class MyModule extends AbstractModule {

    @Provides
    SasDatenProvider provideSas(SasDataProviderHttpImpl http, 
        SasDataProviderFileImpl file){

        boolean isDemo = false; /* do you property lookup logic here */

        return isDemo ? file : http;
    }
}