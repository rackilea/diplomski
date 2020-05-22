public void remove(final List<String> teams, final String name) {
    final int idx = teams.indexOf(name);
    if(idx < 0) 
        throw new IllegalArgumentException("Team " + name + " not present in list.");
    for(int i = idx + 2; i >= idx; --i) 
        teams.remove(i);
}