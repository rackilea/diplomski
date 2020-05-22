public List<String> merge(List<String> base, List<String> other) {
    for(String s : other) {
        if(base.indexOf(s) != 0)
            base.remove(s);
        else continue;
        base.add(s);
    }
    return base;
}