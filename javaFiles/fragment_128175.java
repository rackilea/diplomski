public class Game {
  private int id;
  @XmlElement(name = "GameTitle") //You need to add this since first letter is uppercase, otherwise the GameTitle will not unmarshall.
  private String gameTitle; 
  ... your code ...
}