List<String> listA = new ArrayList<String>();
listA.add("A");
listA.add("B");
listA.add("C");
List<String> listB = new ArrayList<String>();
listB.add("1");
listB.add("2");
listB.add("3");
String[][] multi = new String[listA.size()][listB.size()];
for(int i=0; i < listA.size(); i++) {
    multi[i] = new String[]{listA.get(i), listB.get(i)};
}
System.out.println(multi[0][0] + "," + multi[0][1]);
System.out.println(multi[1][0] + "," + multi[1][1]);
System.out.println(multi[2][0] + "," + multi[2][1]);