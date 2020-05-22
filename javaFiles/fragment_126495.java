public static List<List<Phone>> splitByDateActive(List<Phone> phoneList) {
    Map<String, List<Phone>> map =
        new TreeMap<String, List<Phone>();
    for (Phone phone : phoneList) {
        List<Phone> list = map.get(phone.getDate_active());
        if (list == null) {
            list = new ArrayList<Phone>();
            map.put(phone.getDate_active(), list);
        }
        list.add(phone);
    }
    List<List<Phone>> phoneListSplitted = new ArrayList<List<Phone>>();
    for (List<Phone> phoneListVar : map.values()) {
        phoneListSplitted.addAll(phoneListVar);
    }
    return phoneListSplitted;
}