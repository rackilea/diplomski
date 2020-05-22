import java.util.*;
public class q14968543 {
  public static void main(String[] args) {
    Map<String, List<String>> statePapers = new HashMap<>();
    statePapers.put("Alabama", Arrays.asList((new String[] {"BGNB"})));
    statePapers.put("Alaska",  Arrays.asList((new String[] {"ADNB", "ALKP"})));
    statePapers.put("Arizona", Arrays.asList((new String[] {"ADSB"})));
    statePapers.put("Wyoming", Arrays.asList((new String[] {"WTEB", "WYOM", "WMPP"})));

    for(Map.Entry<String, List<String>> state : selectOnly(statePapers, "Alabama", "NOT A STATE", "Wyoming").entrySet()) {
      System.out.print(state.getKey()+"=");
      for(String paper : state.getValue()) {
        System.out.print(paper+ " ");
      }
      System.out.println();
    }
  }
  private static Map<String, List<String>> selectOnly(Map<String, List<String>> statePapers, String ... states) {
    Map<String, List<String>> selected = new HashMap<>();
    for(String state : states) {
      if(statePapers.containsKey(state)) {
        selected.put(state, statePapers.get(state));
      }
    }
    return selected;
  }
}