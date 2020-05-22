Pattern p = Pattern.compile("^([^:]*):([^-]*)-([^-]*)$");

// I assume this holds all the values:
List<String> uniqueList = new ArrayList<String>(dupMap.values()); 

for (String src : uniqueList) {
    Matcher m = p.matcher(src); 
    if( m.find() && m.groupCount() >= 3) {
        String firstValue = m.group(1); // value to left of :
        String secondValue = m.group(2); // value between : and -
        String thirdValue = m.group(3); // value after -

        // assign to arraylists here
    }
}