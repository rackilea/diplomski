Collections.sort(existingList ,new Comparator<Map<String, Object>>() {
        public int compare(Map<String, Object> o1,Map<String, Object> o2) {
           String name1 = (String)o1.get("name");
           String name2 = (String)o2.get("name");

           if(name1.equalsIgnoreCase("Archived"))
             return 1;
           if(name2.equalsIgnoreCase("Archived"))
               return -1;
           return name1.compareTo(name2);
        }
    });