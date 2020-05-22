public static Map<String, List<EnumKey>> crateEnumKeyMap() {
    Map<String, List<EnumKey>> map = new HashMap<>();

    for (EnumKey enumKey : EnumKey.values()) {
        List<EnumKey> enumKeyList = map.get(enumKey.getGroupName());
        if (enumKeyList == null) {
            enumKeyList = new ArrayList<>();
            map.put(enumKey.groupName, enumKeyList);
        }
        enumKeyList.add(enumKey);
    }
    return map;
}