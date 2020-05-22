public class Dbpediaresults {
  private Results results;

  public Results getResults() {
    return results;
  }

  public void setResults(Results results) {
    this.results = results;
  }

  public static class Results {
    private List<Binding> bindings;

    public List<Binding> getBindings() {
      return bindings;
    }
  }

  public static class Binding {
    private Title title;
    private Content content;
    private Thumbnail thumbnail;

    public Title getTitle() {
      return title;
    }
    public Content getContent() {
      return content;
    }
    public Thumbnail getThumbnail() {
      return thumbnail;
    }
  }

  public static class Title {
    private String value;
    public String getValue() {
      return value;
    }
  }

  public static class Content {
    private String value;
    public String getValue() {
      return value;
    }
  }

  public static class Thumbnail {
    private String value;
    public String getValue() {
      return value;
    }
  }
}