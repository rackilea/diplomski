List<String> merge(List<String> first, List<String> second) {
    if(first.isEmpty()) {return second;}
    if(second.isEmpty()) {return first;}
    List<String> result = new ArrayList<>();
    for(String prefix : first) {
        for(String suffix : second) {
            result.add(prefix + suffix);
        }
    }
    return result;
}