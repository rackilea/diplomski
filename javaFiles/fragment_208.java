public List<String> noZ(List<String> strings) {
    List<String> out = new ArrayList<>();
    for (String s : strings) {
        if (!s.contains("z")) {
            out.add(s);
        }
    }
    return out;
}