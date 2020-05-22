String data = "[[john-london-4455-null],[mark-newyork-null-null],[abishek-null-2244-java developer]]";

//first, remove the first and last square brackets
data = data.substring(1, data.length()-1);
//now separate each object by splitting on the commas
String[] parts = data.split(",");

//create the array that will store all your array data
String[][] lists = new String[parts.length][];

//now create each list and store it in your array
for (int i = 0; i < parts.length; i++) {
    String str = parts[i].substring(1, parts[i].length()-1);
    lists[i] = str.split("-");
}