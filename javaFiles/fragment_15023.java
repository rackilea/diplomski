List<String> domains=new ArrayList<String>(); // values from your file
    domains.add("abc.com");
    domains.add("abc.com");
    domains.add("xyz.com");
   //added for example
    Map<String,Integer> domainCount=new HashMap<String, Integer>();
    for(String domain:domains){
        if(domainCount.containsKey(domain)){
            domainCount.put(domain, domainCount.get(domain)+1);
        }else
            domainCount.put(domain, new Integer(1));

    }
    Set<Entry<String, Integer>> entrySet = domainCount.entrySet();
    for (Entry<String, Integer> entry : entrySet) {
        System.out.println(entry.getKey()+" : "+entry.getValue());
    }