@Override
public int compare(String[] o1, String[] o2) {
    int comparedHash = o1.hashCode() - o2.hashCode();
    if(o1.length != o2.length) return comparedHash;
    List<String> list = Arrays.asList(o1);
    for(String s : o2) {
        if(!list.contains(s)) return comparedHash;
    }
    return 0;
}