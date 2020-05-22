String data = jarray_list.toString();
// omit [ & ]
data = data.substring(1, data.length() - 1);
String[] strNums = data.split(",");

for (String item : strNums) {
    int parsed = Integer.parseInt(item);

}