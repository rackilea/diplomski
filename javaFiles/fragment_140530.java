List<List<String>> stringLists;
String[][] stringArrays = new String[stringLists.size()][];
int i = 0;
foreach (List<String> stringList: stringLists) {
    stringArrays[i] = stringList.toArray(new String[stringList.size()]);
    ++i;
}