String[][] friends = new String[][]{
   {robert, marie}, {jhony, eva}, ​​{mike, laura},
   ​​{adrian, rachel}, {kristen, anthony}
};
List<String> list = new ArrayList<String>();
for(String[] array : friends)
{
    for(String friend : array) list.add(friend);
}
Collections.shuffle(list);
String[] friendfin = new String[list.length];
list.toArray(friendfin); // fill the array
friendfin = Arrays.copyOf(friendfin, 4);