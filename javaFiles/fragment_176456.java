private static Map<String,Integer> orderMappings = new HashMap<>();

    static{
        orderMappings.put("Sunday", 1);
        orderMappings.put("Monday", 2);
        orderMappings.put("Tuesday", 3);
        orderMappings.put("Wednesday", 4);
        orderMappings.put("Thursday", 5);
        orderMappings.put("Friday", 6);
        orderMappings.put("Saturday", 7);
    }

    class OrderComparator implements Comparator<String>{

        @Override
        public int compare(String key1, String key2) {
            int p1 = orderMappings.get(key1);
            int p2 =  orderMappings.get(key2);
            return p1-p2;
        }

    }