String str="The colors are [blue], [yellow], and [green]";

ArrayList<String> arr = new ArrayList<String>();

for(int i = str.indexOf('[', 0); i != -1; i = str.indexOf('[', i + 1)) {
    arr.add(str.substring(i + 1, str.indexOf(']', i)));
}

for(String s : arr) {
    System.out.println(s);
}