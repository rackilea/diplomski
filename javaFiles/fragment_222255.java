public class ToolBean {
    some attributes...
    Map<String, Chamber> chamberMap = new LinkedHashmap<String,Chamber>();
    ...
    public void addChamber(String name, Chamber c) {
        // similar logic as above
    }
    public Chamber getChamber(String name) {
        return chamberMap.get(name);
    }
}

Set<ToolBean> toolBeans = new HashSet<ToolBean>();

ToolBean tb1 = new ToolBean();
tb1.addChamber("one", new Chamber(...));
tb1.addChamber("two", new Chamber(...));
toolBeans.add(tb1);