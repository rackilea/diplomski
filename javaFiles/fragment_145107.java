List<Bar> lb1 = new ArrayList<Bar>();
List<Bar> lb2 = new ArrayList<Bar>();
for (Foo f : foos) {
    lb1.add(doThingOne(f));
    lb2.add(doThingTwo(f));
}