public static Map<String, String> getSomething2(List<String> list) {
    final Map<String, String> map = new HashMap<String, String>();
    forEach(list, new ListToMapAction(map));
    return map;
}


public class ListToMapAction implements Action<String> {

    Map<String, String> map;

    public ListToMapAction(Map<String, String> map) {
        this.map = map;
    }

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

}