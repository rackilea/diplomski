public class Library {
  @JsonProperty("libraryname")
  public String name;

  @JsonProperty("mymusic")
  public List<Song> songs;
}
public class Song {
  @JsonProperty("Artist Name") public String artistName;
  @JsonProperty("Song Name") public String songName;
}

Library lib = mapper.readValue(jsonString, Library.class);