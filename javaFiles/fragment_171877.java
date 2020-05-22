public static void main(String[] args) throws IOException {

  String phrase = "protein kinase A anchor protein activity";
  String txt = "This is a test protein kinase A anchor protein activityThis is a test protein kinase A anchor protein activityThis is ";

  List<Integer> result1 = null;
  List<Integer> result2 = null;

  long currentTime = System.currentTimeMillis();
  for (int i=0; i<1000000; i++) {
        result1 = match(phrase, txt);
  }
  System.out.println("ExecutionTime match: " + (System.currentTimeMillis() - currentTime));

  currentTime = System.currentTimeMillis();
  for (int i=0; i<1000000; i++) {
        result2 = match2(phrase, txt);
  }
  System.out.println("ExecutionTime match2: " + (System.currentTimeMillis() - currentTime));

  Assert.assertTrue(result1.equals(result2));

}