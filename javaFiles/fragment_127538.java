public class hashMap {

    HashMap<String, String> hashMap;
    public hashMap(){
        hashMap=new HashMap<String,String>();
    }
    public void insert(String country,String city){
        hashMap.put(country, city);
    }
    public String get(String key){
        return hashMap.get(key);  //this will return the city of the country
    }
}