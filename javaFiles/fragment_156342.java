public class MyEntryAdapter extends XmlAdapter<HashMap<String, String>, List<MyEntry>> {

    @Override
    public List<MyEntry> unmarshal(HashMap<String, String> map) throws Exception {
        List<MyEntry> entries = new ArrayList<>();
        for (Map.Entry<String, String> entry: map.entrySet()) {
            MyEntry myEntry = new MyEntry();
            myEntry.setKey(entry.getKey());
            myEntry.setValue(entry.getValue());
            entries.add(myEntry);
        }
        return entries;
    }

    @Override
    public HashMap<String, String> marshal(List<MyEntry> entries) throws Exception {
        HashMap<String, String> map = new HashMap<>();
        for (MyEntry entry: entries) {
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }
}