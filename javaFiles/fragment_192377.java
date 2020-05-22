List<String> firstnames = new ArrayList<String>();
List<String lastnames = new ArrayList<String>();
//TODO: populate your lists from the appropriate files
Random rand = new Random();
//The advantage to using a list is that you can choose a random based on the actual
//count of names and avoid any out of bounds conditions.
int firstIndex = rand.nextInt(firstnames.size());
int lastIndex = rand.nextInt(lastnames.size());
//Then you index into the list
String randomfirst = firstnames.get(firstIndex);
String randomlast = lastnames.get(lastIndex);