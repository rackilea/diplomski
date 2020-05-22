String[] names = {"1. John Smith", "2. Tom Cruise", "3. Chuck Norris", "4. Bill Gates", "5. Steve Jobs"};

ArrayList<String> namesList = new ArrayList<>();
for(int i=0; i<names.length; i++) {
    namesList.add(names[i]);
}

Collections.sort(namesList, (name1, name2) -> name1.split(" ")[1].compareTo(name2.split(" ")[1]));

for(String name : namesList) {
    System.out.println(name);
}