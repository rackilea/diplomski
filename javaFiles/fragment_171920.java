public class Product {
   private @XmlElement AuditInfo auditInfo = new AuditInfo();

   public void setDateCreated(...) {
      auditInfo.dateCreated = ...
   }

   public static class AuditInfo {
      private @XmlElement String dateCreated;
   }
}