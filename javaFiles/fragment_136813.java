Map<Integer, String> map = new HashMap<Integer, String>();
/* Add entries to the map. */
...
/* Now get a sorted list of the *values* in the map. */
Collection<String> unsorted = map.values();
List<String> sorted = Util.asSortedList(unsorted);