String s =  "0#Aitem, 0#Aitem2, 0#Aitem3, 1#Bitem, 1#Bitem2, 2#Citem, Nitem, Nitem2";
    Pattern p = Pattern.compile("(\\d*)[#]{0,1}(\\w+?)(,|$)");        
    Matcher m = p.matcher(s);
    Map<String, List<String>> map = new TreeMap<String, List<String>>();
    while(m.find()){
        String group = m.group(1);
        String item = m.group(2);
        List<String> items = map.get(group);
        if(items == null){
            items = new ArrayList<String>();
            map.put(group, items);
        }
        items.add(item);
    }
    //let's print it out
    for(String key : map.keySet()){
        System.out.println(key + " : " + map.get(key));
    }