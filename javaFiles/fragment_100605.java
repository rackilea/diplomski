List<Team> teams = new ArrayList<Team>();

BufferedReader br=new BufferedReader(new FileReader("C:/Users/Fra..../file1"));
BufferedReader br2=new BufferedReader(new FileReader("C:/Users/Fra..../file2"));

String name = null;
String score = null;
while ((score = br.readLine()) != null && (name = br2.readLine()) != null) 
    teams.add(new Team(name, Double.parseDouble(score)));
br.close();
br2.close();

// reverse sort.
Collections.sort(teams, new Comparator<Team>() {
    public int compare(Team t1, Team t2) {
        return Double.compare(t2.score, t1.score);
    }
});


for(Team t: teams)
   System.out.println(t.name + ' ' + t.score);


public class Team {
  final String name;
  final double score;

  public Team(String name, double score) {
    this.name=name;
    this.score=score;
  }
}