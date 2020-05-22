public static class Source {
    private String name;
    private String image;
    private String price;
    private String slug;
    private String shortName;

    @JsonCreator
    public Source(@JsonProperty("_source") Map<String, Object> rawJson) {
      this.name = rawJson.get("name").toString();
      this.image = rawJson.get("image").toString();
      this.price = rawJson.get("price").toString();
      this.slug = rawJson.get("slug").toString();
      this.shortName = rawJson.get("short_name").toString();
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getImage() {
      return image;
    }

    public void setImage(String image) {
      this.image = image;
    }

    public String getPrice() {
      return price;
    }

    public void setPrice(String price) {
      this.price = price;
    }

    public String getSlug() {
      return slug;
    }

    public void setSlug(String slug) {
      this.slug = slug;
    }

    public String getShortName() {
      return shortName;
    }

    public void setShortName(String shortName) {
      this.shortName = shortName;
    }
  }