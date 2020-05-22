// your input file with city, state values
File file = new File("states.txt");

// data structure to hold mapping of state to list of cities, sorted by state
SortedMap<String, List<String>> map = new TreeMap<String, List<String>>();

// scan file by line and populate data structure
Scanner scanner = new Scanner(file).useDelimiter("\\n");
while (scanner.hasNext()) {
    String line = scanner.next();

    // only process lines with a comma
    if (line.contains(",")) {
        // split the line on the comma and extract the city and state
        // note this won't work properly if the city has a comma in it
        String[] parts = line.split(",");
        String city = parts[0].trim();
        String state = parts[1].trim();

        // if the state doesn't exist in the map yet, create it
        List<String> cities = map.get(state);
        if (cities == null) {
            cities = new ArrayList<String>();
            map.put(state, cities);
        }

        // add the city to the list for the state if it's not in it yet
        if (!cities.contains(city)) {
            cities.add(city);
        }
    }
}

// iterate over the states for output
for (String state : map.keySet()) {
    // build up a string for each state with the list of cities
    StringBuilder sb = new StringBuilder();

    // start with the state
    sb.append(state + ": ");

    // now append the cities
    List<String> cities = map.get(state);
    for (String city : cities) {
        sb.append(city + ", ");
    }

    // remove the last comma
    sb.delete(sb.length() - 2, sb.length());

    // print out the finished line
    String output = sb.toString();
    System.out.println(output);
}