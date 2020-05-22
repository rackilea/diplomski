Collections.sort(list, new Comparator<Map<String, String>>() {

        @Override
        public int compare(Map<String, String> o1, Map<String, String> o2) {
            String value1 =  o1.get("amount");
            String value2 =  o2.get("amount");
            return Integer.parseInt(value1)-Integer.parseInt(value2);
        }
    });

    for (Map<String, String> map1 : list) {
        String id = map1.get("id");
        String amount = map1.get("amount");
        System.out.println("amount= "+amount + " , " +"id = "+id);
    }