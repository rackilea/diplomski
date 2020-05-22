//defined somewhere
List<List<String>> lists = ....

String[][] array = new String[lists.size()][];
String[] blankArray = new String[0];
for(int i=0; i < lists.size(); i++) {
    array[i] = lists.get(i).toArray(blankArray);
}