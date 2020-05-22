for(int i = 0;i<item.size();i++) {
        // get the next element as a Object and print it
        System.out.println("The "+i+" element of the array: "+item.get(i));

        // get the next element as a JSONObject
        JSONObject obj = item.getJSONObject(i);
        Iterator<String> itr = obj.keys();
        // print all its keys/value pairs
        while (itr.hasNext()) {
            String key = itr.next();
            String value = obj.getString(key);
            System.out.println("key=" + key + ", value=" + value);
            // key=email, value=xy@z.com
            // key=name, value=abcdef
            // key=Id, value=123
            // ...
        }
    }