String favs = "[36, 40, 16]";
String replace = favs.replace("[","");
String replace1 = replace.replace("]","");
List<String> arrayList = new ArrayList<String>    (Arrays.asList(replace1.split(",")));
List<Integer> favList = new ArrayList<Integer>();
for(String fav:arrayList){
    favList.add(Integer.parseInt(fav.trim()));
}