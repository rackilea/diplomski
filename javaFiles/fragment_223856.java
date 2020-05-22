public List<String> translationList(){
    List<String> list = new ArrayList<>();
    for ( String key : dictionary.keySet() ) {
        list.add(key+" = "+dictionary.get(key));
    }
    return list;
}