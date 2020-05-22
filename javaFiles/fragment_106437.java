public static class Test{
        public <T extends Serializable> void set(String key, Map<String, T> fields) {

        }
    }


    public static void main(String[] args) {
        HashMap<String, String> fieldMapL1 = new HashMap<>();
        fieldMapL1.put("ABC", "XYZ");
        Map<String, HashMap<String, String>> fieldmap2 = new HashMap<>();
        fieldmap2.put("key", fieldMapL1);

        Test test = new Test();
        test.set("key", fieldmap2);
    }