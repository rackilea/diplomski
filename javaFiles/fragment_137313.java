public List<String> readFromHashtable(Hashtable recruiters){
    List<String> urls = new ArrayList<String>(recruiters.size());      
    for(Entry e : recruiters.entrySet()){
        urls.add(e.getValue() + '/' + e.getKey());
    }
    return urls;
}