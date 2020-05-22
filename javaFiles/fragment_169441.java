List<HashMap<String, String>> personList = new ArrayList<HashMap<String, String>>(); //Your list
List<HashMap<String,String>> filtered = new ArrayList<HashMap<String,String>>();

for(HashMap<String, String> person : personList){
    if("your_cnic".equals(person.get("cnic"))){
        filtered.add(person);
    }
}