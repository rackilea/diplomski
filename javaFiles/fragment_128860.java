public class q14968543 {
  public static void main(String[] args) {
    String statePapersInitial[][] = {
      { "Alabama", "BGNB" },
      { "Alaska",  "ADNB", "ALKP" },
      { "Arizona", "ADSB" },
      { "Wyoming", "WTEB", "WYOM", "WMPP" }
    };

    for(String[] papers : selectOnly(statePapersInitial, "Alabama", "Wyoming")) {
      for(String paper : papers) {
        System.out.print(paper+ " ");
      }
      System.out.println();
    }
  }

  private static String[][] selectOnly(String[][] statePapers, String ... states) {
    String[][] selected = new String[states.length][0];
    int index = 0;
    for(String state : states) {
      for(String[] papers : statePapers) {
        if(state.equals(papers[0])) {
          selected[index++] = papers;
        }
      }
    }
    return selected;
  }
}