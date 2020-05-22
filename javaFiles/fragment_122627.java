@Entity
@...
class YourEntity {
   ...

   private Map<String, Double> keywords;

   @ElementCollection(fetch = FetchType.EAGER)
   public ScoreMap<String> getKeywords() {
      // This is fine as we know the Map will always be a ScoreMap
      return (ScoreMap<String>) keywords;
   }

   public void setKeywords(final Map<String, Double> keywords) {
      this.keywords = new ScoreMap<>(keywords);
   }
}