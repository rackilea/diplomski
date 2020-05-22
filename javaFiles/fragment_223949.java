String pattern = "[:\\-]";

// I assume this holds all the values:
List<String> uniqueList = new ArrayList<String>(dupMap.values()); 

for (String src : uniqueList) {
    String[] parts = src.split(pattern);
    if (parts.length == 3) {
        String firstValue = parts[1]; // value to left of :
        String secondValue = parts[2]; // value between : and -
        String thirdValue = parts[3]; // value after -

        // assign to arraylists here
    }
}