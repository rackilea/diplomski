public static Map<String, String> getSomething(List<String> list) {
    final Map<String, String> map = new HashMap<String, String>();
    forEach(list, new Action<String>() {
        @Override
        public void action(String e) {
            if (e.contains("aaa")) {
                map.put("aaa", e);
            }
            if (e.contains("bbb")) {
                map.put("bbb", e);
            } else {
                // do nothing
            }
        }
    });
    return map;
}