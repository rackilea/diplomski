final HashMap<String, Integer> map = new HashMap<String, Integer>();
    map.put("abcd",5);
    map.put("xyz",152);
    map.put("pqr",1);
    List list = new ArrayList<String>(map.keySet());

    System.out.println("before : "+ list);
    Collections.sort(list, new Comparator<String>(){
        public int compare(String item1, String item2){
            int compare = map.get(item1) - map.get(item2);
            if(compare == 0)
            {  
                return (item1.compareTo(item2)); 
            }
            return compare;
        }
    });

    System.out.println("after : "+ list);