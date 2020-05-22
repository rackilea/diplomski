String [] someArray = new String[]{"A", "B", "C", "A", "B", "C"};
    Map<String,Integer> repeatationMap= new HashMap<String,Integer>();
    for(String str : someArray){

        if(repeatationMap.containsKey(str)) {
            repeatationMap.put(str,repeatationMap.get(str) + 1);
        }
        else {
            repeatationMap.put(str, 1);
        }
    }

    int count = 0;
    for(int repatCount : repeatationMap.values()){
        if(repatCount > 1) {
            count++;
        }
    }
    System.out.println("Number of Strings repeated : " + count);