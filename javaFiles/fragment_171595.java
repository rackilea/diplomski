List<String> list1 = new ArrayList<>(Arrays.asList("Hello", "Keyword", "Bye"));
String[] stringarray = new String[]{"Blah1", "Blah2", "Blah3"};
int index = list1.indexOf("Keyword"); //get the index of the keyword
if(index != -1){ //if it's different than -1, it means that the list contains the keyword
    list1.remove(index); //remove the keyword from the list
    list1.addAll(index, Arrays.asList(stringarray)); //insert the array in the list at the position where keyword was
}
System.out.println(list1);