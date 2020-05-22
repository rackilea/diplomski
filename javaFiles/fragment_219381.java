static void countWords(String st){
  Map<String, Long> wordsAndCounts = 
     Arrays.stream(st.split("\\s")).    //Splt the string by space i.e., word
         collect(Collectors.groupingBy( //Apply groupby
         Function.identity(),          //Map each word
         Collectors.counting()         //Count how many words
     ));
    System.out.println(wordsAndCounts);
}