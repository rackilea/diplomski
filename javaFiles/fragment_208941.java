public class Recording implements Comparable {

  private int id;
  private int year;
  private Artist artist;
  private String name;

  public Recording() {}
  public Recording(Artist artist, String name, int year) {
    this.artist = artist;
    this.name = name;
    this.year = year;
  }

  public int compareTo(Object obj) {
    Recording r = (Recording) obj;
    return name.compareTo(r.name);
  }

  public Artist getArtist() { return artist; }
  public void setArtist(Artist artist) { this.artist = artist; }

  public int getId() { return id; }
  public void setId(int id) { this.id = id; }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public int getYear() { return year; }
  public void setYear(int year) { this.year = year; }
}