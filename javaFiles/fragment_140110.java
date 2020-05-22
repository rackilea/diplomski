String input = "PECASH 1 3 6";
boolean acsending = isAcsending(input); 

...

public static isAcsending(String input) {

   String[] splitted = input.split("\\s+");  // tokenize string
   List<Integer> ints = new ArrayList<>(); 
   for (String s : splitted) {  
     try {
         ints.add(Integer.parseInt(s));         // try to parse each token 
     } catch (RuntimeException ignored) { }
   }
   List<Integer> sorted = new ArrayList<>(ints);
   Collections.sort(sorted);
   return ints.equals(sorted);               // compare
}