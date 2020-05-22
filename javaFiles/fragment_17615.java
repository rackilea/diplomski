@ProxyFor(MyEntity.class)
interface MyEntityProxy extends EntityProxy {
   String getServerVersion();
   String getClientVersion();
   void setClientVersion(String clientVersion);
   …
}

@Entity
class MyEntity {
   private String clientVersion;
   @Version private String serverVersion;

   public String getServerVersion() { return serverVersion; }
   public String getClientVersion() { return null; }
   public void setClientVersion(String clientVersion) {
      this.clientVersion = clientVersion;
   }

   public void checkVersion() {
      if (Objects.equal(serverVersion, clientVersion)) {
         throw new OptimisticConcurrencyException();
      }
   }
}