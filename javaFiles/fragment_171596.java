for(int i = 0; i < list1.size(); i++) {
    if(list1.get(i).contains("Keyword")){
        list1.remove(i); 
        list1.addAll(i, Arrays.asList(stringarray)); 
    }
}
System.out.println(list1);