public class TestMapModify {
    public static void main(String[] argvs) {
        Map<String, Object> m = new HashMap<String, Object>();
        Map<String, Object> anotherMap = new HashMap<String, Object>();

        m.put("a", 1);
        m.put("b", 2);
        for (Iterator<Map.Entry<String, Object>> it = m.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, Object> entry = it.next();
            if (entry.getKey().equals("a")) {
                anotherMap.put("c", entry.getValue());
                it.remove();
            }
        }
        m.putAll(anotherMap);
        System.out.println(m);
    }
}