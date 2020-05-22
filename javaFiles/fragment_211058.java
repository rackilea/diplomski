for(Map.Entry<String, List<String>> items: hashmapobj.entrySet()){
    System.out.print(items.getKey());
    List<String> list = items.getValue();
    for(String s : list){
        System.out.print(" " + s);
    }
    System.out.println();
}