public class SerializeDemo{

      @JsonIgnore
      private String serializeOnly;


      @JsonProperty("serializeOnly")
      public String getSerializeOnly() {
        return serializeOnly;
      }

      @JsonIgnore
      public void setSerializeOnly(String serializeOnly) {
        this.serializeOnly= serializeOnly;
      }
    }