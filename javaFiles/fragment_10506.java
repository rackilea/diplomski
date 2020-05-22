Iterator<String> iterator = (Iterator<String>) myList.iterator();
while (iterator.hasNext()) {//List tagListAux
        System.out.println("Test -> "+iterator.next());
        if(iterator.next().equalsIgnoreCase(myString)){
        flag = true;
}