String[] input = new String[] {"Maria Carolina", "Luisa Joana", "Lara Silva", "Catarina Patricio", "Paula Castro", "fim", null, null, null};
List<String> namesList = new ArrayList<>();
for(String name : input) {
    if(name != null && name.matches("^[A-Z][A-z]+ [A-Z][a-z]+$"))
        namesList.add(name);
}
String[] namesArray = namesList.toArray(new String[0]);
System.out.println(Arrays.toString(namesArray));