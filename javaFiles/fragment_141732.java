import java.util.Random;

public class gramatica {
  public static void main(String[] args) {

    String [] Vt = {"S","R","L"};
    String [] Vn = {"a","b","c","d","e","f"};

    String [] S = {

            "aS","bS","cR","dL"
    };

    String[] R = {
            "dL","e"
    };

    String []L = {

            "fL","eL","d"
    };
    //System.out.println(S[0]);
    String rule = "S";

    Random r = new Random();

    // Make a loop
    while(true) {
      if(rule.contains("S")) {
        rule = rule.replaceFirst("S", S[r.nextInt(S.length)]);
        continue;
      };
      if(rule.contains("R")) {
        rule = rule.replaceFirst("R", R[r.nextInt(R.length)]);
        continue;
      };
      if(rule.contains("L")) {
        rule = rule.replaceFirst("L", L[r.nextInt(L.length)]);
        continue;
      };

      // Nothing to change, break loop
      break;
    };

    // Now we got a random possible rule for S! :)
    System.out.println("S->"+rule);
  };
};