//list3 created.
    for(HashMap<String,String> hm2:list2){
        String nameValue=hm2.get("name");
        for(HashMap<String,String> hm1:list1){
            if(hm1.get("name").equalsIgnoreCase(nameValue)){
                HashMap<String,String> tempMap = new HashMap();
                tempMap.put("name",nameValue);
                tempMap.put("count",hm1.get("count"));
                tempMap.put("change",hm2.get("change"));
                list3.add(tempMap);
                break;
            }
        }

    }
    System.out.println(list3);