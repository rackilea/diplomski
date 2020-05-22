Map<String, String> dateMap = new TreeMap<String, String>();
dateMap.put("2015/08/27", "1|Prod23");
dateMap.put("2015/12/15", "1|Prod55");
dateMap.put("2016/04/08", "1|Prod09");
dateMap.put("2016/04/12", "3|Prod09");
dateMap.put("2016/04/09", "2|Prod09");

String lastKey = "";
String currentKey = "";
List<String> date = new ArrayList<String>();
List<String> release = new ArrayList<String>();
for(Map.Entry<String, String> entry : dateMap.entrySet()) {
    String temp = entry.getKey();
    currentKey = temp.substring(0, 7);
    if(currentKey.equals(lastKey)){ // another release in same month as previous release
        // Remove last release details
        date.remove(date.size() - 1);
        release.remove(release.size() - 1);
        // Add current release deetails
        date.add(temp);
        release.add(entry.getValue());
        lastKey = currentKey;
    } else { // first release in this month
        // Add current release deetails
        date.add(temp);
        release.add(entry.getValue());
        lastKey = currentKey;
    }
}