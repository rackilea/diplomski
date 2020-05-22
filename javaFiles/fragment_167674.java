boolean allElementsPresent = true;
    for (String list11 : list1) {
            if (!list22.contains(list11)){
                allElementsPresent = false;                
            }
    }
if(allElementsPresent){
    System.out.println ("List 2 contains the strings from list1");
}