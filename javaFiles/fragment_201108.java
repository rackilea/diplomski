public boolean addTo(Record record) {
    if(exists(record)){
       return false;
    } else {
       map.put(record.getTitle(), record);
       return true;
    }   
}