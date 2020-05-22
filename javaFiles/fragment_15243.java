import java.util.ArrayList;
import java.util.List;

public class p {
    public static void main(String[] args) {
    // Group1 consists of 4 teams, A,B,C and D
    List<String>Group1= new ArrayList<String>() ; 
    Group1.add("A");
    Group1.add("B");
    Group1.add("C");
    Group1.add("D");
    // matches stores the names of the teams which have been selected for a match
    List<String>matches = new ArrayList<String>();
    for(String team1: Group1) {
      for(String team2: Group1) {
        if(!team1.equals(team2) && !matches.contains(team1+team2) && !matches.contains(team2+team1)) {
          matches.add(team1+team2);
          System.out.println(team1 + " vs " + team2); 
        }
      }
    }
    }
}