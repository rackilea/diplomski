Comparator<HashMap<String, String>> distanceComparator = new Comparator<HashMap<String,String>>() {

    @Override
    public int compare(HashMap<String, String> o1, HashMap<String, String> o2) {
        // Get the distance and compare the distance.
        Integer distance1 = Integer.parseInt(o1.get("distance"));
        Integer distance2 = Integer.parseInt(o2.get("distance"));

        return distance1.compareTo(distance2);
    }
};

// And then sort it using collections.sort().
Collections.sort(arrayList, distanceComparator);