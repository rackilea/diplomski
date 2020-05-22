LinkedHashMap<String, List<List<String>>> hashMap_searchresult = new LinkedHashMap<>();

List<List<String>> list = new ArrayList<>();
list.add(new ArrayList<String>(Arrays.asList("a", "b", "c", "d")));
list.add(new ArrayList<String>(Arrays.asList("e", "f", "g", "h")));
hashMap_searchresult.put("a1", list);

for (Map.Entry<String, List<List<String>>> entry : hashMap_searchresult.entrySet()) {
    String key = entry.getKey();
    List<List<String>> value2222 = entry.getValue();
    for (List<String> lst : value2222) {
        String[] arr = new String[list.size()];
        arr = lst.toArray(arr);
        System.out.println("checkstatus" + " key    " + key + " value : " + Arrays.toString(arr));
    }
}