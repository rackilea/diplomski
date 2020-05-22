@Configuration
@ConfigurationProperties
class AppProperties {
   private String serverSSLKeyStore;
   // the other properties

   public void setServerSslKeyStore(String value) {
     this.serverSSLKeyStore = value;
   }

   public String getServerSslKeyStore() {
     return this.serverSSLKeyStore;
   }
}