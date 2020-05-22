public static void testCopy() {
        HashMap<String, Object> hash1 = new HashMap<String, Object>() {{
            put("key1", "value1");
            put("key2", 2000);
        }};

        HashMap<String, Object> hash2 = new HashMap<String, Object>() {{
            put("key31", "value31");
            put("key32", 3200);
        }};

        HashMap<String, Object> hash3 = new HashMap<String, Object>() {{
            put("key41", "value41");
            put("key42", 4200);
            put("key43", true);
        }};

        HashMap<String, Object> hash4 = new HashMap<String, Object>() {{
            put("key51", "value51");
            put("key52", 5200);
            put("key53", true);
        }};

        hash3.put("hashKey4", hash4);
        hash2.put("hashKey3", hash3);
        hash1.put("hashKey2", hash2);

        try {
            JSONObject json = hashMap2JSONObject(hash1);
            String jsonString = json.toString();
            Log.d("testCopy()", jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }