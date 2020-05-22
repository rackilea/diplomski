import java.util.ArrayList;
import java.util.Arrays;

public class Comb {
  static long combinations(String str, int startIdx, int numBytes, ArrayList<byte[]> combinations, byte[] combination) {
    if(startIdx >= str.length()) {
       if(numBytes == 16) {
         combinations.add(combination.clone());
         return 1;
       } else return 0;
    }
    if(numBytes > 15) return 0;
    combination[numBytes] = (byte)(str.charAt(startIdx) - '0');
    long result = combinations(str, startIdx + 1, numBytes + 1, combinations, combination);
    if(startIdx < str.length() - 1 && str.charAt(startIdx) != '0') {
      combination[numBytes] = (byte)((str.charAt(startIdx) - '0') * 10 + (str.charAt(startIdx + 1) - '0'));
      result += combinations(str, startIdx + 2, numBytes + 1, combinations, combination);
    }
    if(startIdx < str.length() - 2) {
      combination[numBytes] = (byte)((str.charAt(startIdx) - '0') * 100 + (str.charAt(startIdx + 1) - '0') * 10 + (str.charAt(startIdx + 2) - '0'));
      if(str.charAt(startIdx) == '1') result += combinations(str, startIdx + 3, numBytes + 1, combinations, combination);
      if(str.charAt(startIdx) == '2' &&
        (str.charAt(startIdx + 1) < '5' || str.charAt(startIdx + 1) == '5' && str.charAt(startIdx + 2) < '6')) {
          result += combinations(str, startIdx + 3, numBytes + 1, combinations, combination);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    ArrayList<byte[]> combinations = new ArrayList<>();
    System.out.println(combinations("1518918615824625494170109603025017352201241", 0, 0, combinations, new byte[16]));
    for(byte[] c: combinations) {
      System.out.println(Arrays.toString(c));
    }
  }
}