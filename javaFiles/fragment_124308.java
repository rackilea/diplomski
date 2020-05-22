for(Map.Entry<String, List<Integer>> entry : userScores.entrySet()) {
   String user = entry.getKey();
   List<Integer> scores = entry.getValue();

   //to iterate over the list of scores
   for(int score : scores) {
       ...
   }   
}