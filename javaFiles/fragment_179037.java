for(List<Character> p:nodes) {
    LinkedHashSet<Character> set = new LinkedHashSet<>(p);
    set.remove(p.get(p.size()-1));
    set.add(p.get(p.size()-1));
    modified.add(set);
}