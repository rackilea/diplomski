Map<Integer, Map<String, String>> data = new LinkedHashMap<Integer, Map<String, String>>();
Map<String, String> subData;
for (int j= 0; j <fsplit.length;) {
    subData = new HashMap<String, String>();
    int i=0;
    while(i<3){
        String s = fsplit[j++];
        String[] parts = s.split("=");
        if (parts.length == 2) {
            subData.put(parts[0], parts[1]);
        }
        i++;
    }
    data.put(j/3, subData);
}