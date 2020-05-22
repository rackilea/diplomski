public static List<Integer> match2(String pattern, String text) {
  List<Integer> result = new ArrayList<Integer>();

  int[] right = new int[256]; // Assuming a 256 character encoding
  for (int c = 0; c < 256; c++)
        right[c] = -1;
  for (int j = 0; j < pattern.length(); j++)
        right[pattern.charAt(j)] = j;

  int M = pattern.length();
  int N = text.length();
  int skip;
  for (int i = 0; i <= N - M; i += skip) {
        skip = 0;
        for (int j = M-1; j >= 0; j--) {
              if (pattern.charAt(j) != text.charAt(i+j)) {
                    skip = Math.max(1, j - right[text.charAt(i+j)]);
                    break;
              }
        }
        if (skip == 0) {    // found
          result.add(i);
          skip += pattern.length();
        }
  }
  return result;
}