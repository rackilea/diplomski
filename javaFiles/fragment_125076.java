class Story {
  public final int id;
  public String title;
  public String keyword;
  public String targeting;

  public Story(int storyId) {
    id = storyId ;
  }
}

class MultiStory {
  public final int id;
  public String title;
  public Set<String> keywords = new HashSet<>();
  public Set<String> targetingInfo = new HashSet<>();

  public MultiStory( int storyId ) {
    id = storyId ;
  }
}