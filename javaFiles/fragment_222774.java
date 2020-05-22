List<String> arrayList = new ArrayList<>();
arrayList.add("ex1");
arrayList.add("ex2");
arrayList.add("ex12");

for (String element : arrayList) {
    switch (element) {
    case "ex1":
        // Do something
        break;
    default:
        // Do something else
    }
}