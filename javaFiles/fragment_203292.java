Map<String, Queue<String>> map = new LinkedHashMap<>();

List<PlaceTime> list = new ArrayList<>(
            Arrays.asList(
            new PlaceTime("Ravensbusch street 04:41 05:41 06:09 06:38 07:08 07:38 08:08 08:38 09:08 09:38 10:08 10:38 11:08 11:38"), 
            new PlaceTime("Ravensbusch street 04:41 05:41 06:09 06:38 07:08 07:38 08:08 08:38 09:08 09:38 10:08 10:38 11:08 11:38"),
            new PlaceTime("Ravensbusch street 19:08 19:38 20:08 20:38 21:38 22:38 23:38")));

for (PlaceTime t:list) {
    if (map.containsKey(t.getPlace())) {
        //If the map already contains an entry for the place, add the times to the array
        map.get(t.getPlace()).addAll(t.getTimes());
    } else {
        //Map does not contain entry for place, create a new entry
        map.put(t.getPlace(), t.getTimes());
    }
}

//Print out contents of map
for (Entry<String, Queue<String>> entry:map.entrySet()) {
    System.out.println(entry.getKey());
    System.out.println(entry.getValue());
}