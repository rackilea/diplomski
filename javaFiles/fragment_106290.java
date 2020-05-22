// original list
List<String> list = new ArrayList<String>(Arrays.asList("02, String1", "03, Num1", 
                                         "03, Num2", "02, String2"));
int numToAdd = 3; // number of additional entries
int spos=0; // starting position of insertion
List<String> list03 = new ArrayList<String>(); // list to hold all 03 entries
for (int i=0; i<list.size(); i++) {
    if (list.get(i).contains("03,")) {
        if (spos == 0) spos = i; // set only once
        list03.add(list.get(i));
    }
}
// add list03 into main list numToAdd times
for (int i=0; i<numToAdd; i++)
    list.addAll(spos, list03);
// print the main list
for (String s: list)
    System.out.println(s);