while (line != null) {
    if (line.indexOf("->") != -1) {
        String From = line.substring(0, line.indexOf("->")-1);
        String To = line.substring(line.indexOf('>')+2);

        if (! hm.containsKey(From)) {
            hm.put(From, new City(From));
        }
        hm.get(From).addDestination(To);
    }
}