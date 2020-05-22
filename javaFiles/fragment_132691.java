//create the map and the list of adjectives
Map<Character, String> adjectives = new HashMap<>();
List<String> personAdjectives = new ArrayList<>();
//fill the map (although it would be better retrieving data from a database)
adjectives.put('a',"adventurous");
adjectives.put('b',"bold");
// ...
//convert the name to a char array
char[] chars = name.toCharArray();
//iterate over it
for(char c : chars){
  //access the map and fill the list
  personAdjectives.add(adjectives.get(c));
}
//print the list