public List<Map<String, String>> createMappings(List<String> datacenters, List<String> hosts) {
    List<Map<String, String>> result = new ArrayList<Map<String, String>>();
    for(int i = 0; i < hosts.size(); i++) {
        Map<String, String> row = new HashMap<String,String>();
        for(int j = 0; j < datacenters.size(); j++) {
            String datacenter = datacenters.get(j);
            int hostIndex = (j + i) % hosts.size();
            String host = hosts.get(hostIndex);
            row.put(datacenter, host);
        }
        result.add(row);
    }
    return result;
}