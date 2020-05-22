public class XmlStringMapAdapter extends XmlAdapter<MapElement, Map<String, String>> {

    @Override
    public MapElement marshal(Map<String, String> v) throws Exception {

        if (v == null || v.isEmpty()) {return null;}

        MapElement map = new MapElement();

        for (String key : v.keySet()) {
            map.addEntry(key, v.get(key));
        }

        return map;
    }

    @Override
    public Map<String, String> unmarshal(MapElement v) throws Exception {
        if (v == null) {return null;}

        Map<String, String> map = new HashMap<String, String>(v.entries.size());

        for(EntryElement entry: v.entries) {
            map.put(entry.key, entry.value);
        }

        return map;
    }

}