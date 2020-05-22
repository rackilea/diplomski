public static List<String> toNameStrings(List<Name> names) {
    List<String> list = new ArrayList<String>(names.size());
    for (Name name : names) {
        list.add(name.getName());
    }
    return list;
}