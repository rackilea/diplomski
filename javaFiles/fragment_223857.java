public List<String> translationList(){
    List<String> list = new ArrayList<>();
    for ( Map.Entry<String,String> entry : dictionary.entrySet() ) {
        list.add(entry.getKey()+" = "+entry.getValue());
    }
    return list;
}