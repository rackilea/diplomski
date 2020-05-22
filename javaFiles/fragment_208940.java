import java.util.List;

public class Artist implements Comparable {

  private int id;
  private List<Recording> recordings;
  private String name;

  public Artist() {}
  public Artist(String name) { this.name = name; }

  public int compareTo(Object obj) {
    Artist r = (Artist) obj;
    return name.compareTo(r.name);
  }

  public int getId() { return id; }
  public void setId(int id) { this.id = id; }

  public String getName() { return name; }
  public void setName(String name) {
    this.name = name;
  }

  public List<Recording> getRecordings() { return recordings; }
  public void setRecordings(List<Recording> recordings) {
    this.recordings = recordings;
  }
}