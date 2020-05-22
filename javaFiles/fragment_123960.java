public class Agent extends Person implements Serializable {
  float dueAmount;
  int percentage;
  public ArrayList<Artist> agentArtists;

  public Agent() 
  {
    super();
    agentArtists = new ArrayList<Artist>();
    dueAmount = 0;
    percentage = 0;
  }

  public ArrayList<Artist> getAgentArtists() 
  {
    return agentArtists;
  }

  public void setAgentArtists(Artist art) 
  {
    agentArtists.add(art);
  }
}