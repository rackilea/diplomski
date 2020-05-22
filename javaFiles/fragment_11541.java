public class translatekeyName {
    static List<String> finalString = new ArrayList<>();

    public static Map<String, String> initialMap() {
        Map<String, String> map1 = new HashMap<>();
        map1.put("37", "core__error_code_based");
        map1.put("153", "core__app_dialog");
        return map1;
    }

    public static Map<String, String> secondMap() {
        Map<String, String> map2 = new HashMap<>();
        map2.put("copy_2", "37");
        map2.put("button_back", "37");
        map2.put("button_cancel", "153");
        map2.put("button_confirm", "153");
        return map2;
    }

    public List<String> concatenateString(Map page, Map source) {
        Map<String, String> moduleKey = page;
        Map<String, String> pageKey = source;
        List<String> temp;

        Iterator<Map.Entry<String, String>> entrySet = page.entrySet().iterator();
        Iterator<Map.Entry<String, String>> pageKeyset = source.entrySet().iterator();
        for (String value : moduleKey.keySet()) {
            temp = getallKeys(source, value);
            String tempValue = moduleKey.get(value);
            for (int i = 0; i < temp.size(); i++) {
                tempValue += "__" + temp.get(i);
                finalString.add(tempValue);
            }

        }

        return finalString;
    }

    static <K, V> List<K> getallKeys(Map<K, V> mapOfWords, V value) {
        List<K> keylist = null;


        if (mapOfWords.containsValue(value)) {

            keylist = new ArrayList<>();

            for (Map.Entry<K, V> entry : mapOfWords.entrySet()) {

                if (entry.getValue().equals(value)) {
                    keylist.add(entry.getKey());
                }
            }
        }

        return keylist;
    }

    public static void main(String[] args) {
        translatekeyName obj = new translatekeyName();
        obj.concatenateString(initialMap(), secondMap());
        System.out.println(finalString);
    }

}