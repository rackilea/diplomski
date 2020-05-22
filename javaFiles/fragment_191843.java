List<HashMap<String,String>> newArray = new ArrayList<HashMap<String, String>>();

for(HashMap<String, String> hm : contactListad){
    String val = hm.get("homeAddress");
    if("paris".equals(val)){
        newArray.add(hm);
    }

}