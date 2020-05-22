Map<String,Integer> mp = new HashMap<>();

mp.put("Delhi",1);
mp.put("Bombay",1);
mp.put("Bangalore",1);

int numberOfTrips = 5;
List<String> orderOfVisits = Arrays.asList("Delhi", "Bombay", "Bangalore");
Iterator<String> visiterator = orderOfVisits.iterator();

for (int i = 0; i < numberOfTrips; i++) {
  // Get a new iterator if we've exhausted the previous one
  if (!visiterator.hasNext()) {
    visiterator = orderOfVisits.iterator();
  }

  // Get the correct city and increment the counter
  String key = visiterator.next();
  mp.put(key, mp.get(key) + 1);
}

// demonstrate that the map contains the correct values
for (Entry<String, Integer> entry: mp.entrySet()) {
  System.out.println("Key:" + entry.getKey() + ", Value:" + entry.getValue());
}