String sStr = "in the morning";
String str = "in the morning at 5";
List<String> searchStringList = new ArrayList<String>();
searchStringList.add(sStr);

for(String searchString : searchStringList) {
    if(str.startsWith(searchString)) {
        return true;
    }
}