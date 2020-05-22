List<Integer> results = new ArrayList<Integer>();
while (there are more results) { // here you ask the regex if it found some more item
   // add integer to results
   String found = ... // here you grab the string you've just found
   results.add(Integer.parseInt(found)); // convert the string to integer and add to list
}