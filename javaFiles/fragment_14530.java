@XmlAccessorType(XmlAccessType.FIELD)
class Mapping
{
   @XmlAccessorType(XmlAccessType.FIELD)
   private static class Search
   {
      private String channel;
      private String url;
   }

   private Search search;

   public String getUrl()
   {
      return search == null ? null : search.url;
   }
}