public class Main
{
  private static Random random = new Random();

  public static void main(String[] args)
  {
      // 'list' array list contains animals
      List<String> list = new ArrayList<String>();
      list.add("Tiger");
      list.add("Crocodile");
      list.add("Cat");
      list.add("Dog");
      list.add("Elephant");
      list.add("Lion");
      list.add("Deer");
      list.add("Eagle");
      list.add("Monster");
      list.add("Alien");
      list.add("Vombie");
      list.add("Politician");
      list.add("Donkeye");

      List<String> teamA = new ArrayList<String>();
      List<String> teamB = new ArrayList<String>();
      String newAnimal;

      int totalAnimalsForTeams = 7; // <- probably get this value from the user?

      if (totalAnimalsForTeams > list.size())
      {
          System.out.println("There are only " + list.size() + " animals in the list. Requested animals was: " + totalAnimalsForTeams);
          return;
      }

      int firstHalf = totalAnimalsForTeams / 2; 

      if (firstHalf < 1)
      {
          System.out.println("Requested " + totalAnimalsForTeams + " animals for teams... not enough to make two teams!");
          return;
      }

      for(int i = 0; i < firstHalf; i++)
      {
        newAnimal = getRandomList(list);
        teamA.add(newAnimal);
        list.remove(newAnimal);
      }

      int secondHalf = totalAnimalsForTeams - firstHalf;

      for(int i = 0; i < secondHalf; i++)
      {
        newAnimal = getRandomList(list);
        teamB.add(newAnimal);
        list.remove(newAnimal);
      }
      System.out.println(teamA); 
      System.out.println(teamB);             
  }

  public static String getRandomList(List<String> list) {

      //0-4
      if (list.size() > 1)
      {
          int index = random.nextInt(list.size());
          //System.out.println("\nIndex :" + index ); 
          return list.get(index);
      }
      else
      {
          return list.get(0);
      }

  } 
}