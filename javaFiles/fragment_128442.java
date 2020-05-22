public static void main(String[] args) {
        // hashmap goes like this
        LinkedHashMap<String, List<String>> hash = new LinkedHashMap<String, List<String>>();

        // put some values in some arraylist
        List<String> value1 = (List<String>) Arrays.asList("s1", "s2", "s3");
        List<String> value2 = (List<String>) Arrays.asList("s4", "s5", "s6");
        List<String> value3 = (List<String>) Arrays.asList("s7", "s8", "s9");

        // put values in hashmap
        hash.put("key1", value1);
        hash.put("key2", value2);
        hash.put("key3", value3);

        int count = 0;
        boolean exit = false;
        while (!exit) {
            for (String key : hash.keySet()) {
                String value = hash.get(key).get(count);
                System.out.printf("\t" + value);
            }
            System.out.printf("\n");
            count++;
            if (count == hash.get("key1").size()) {
                exit = true;
            }
        }

    }