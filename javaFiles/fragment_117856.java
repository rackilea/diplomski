private static List<R> createResource(List<Line> l, Long pid) {
    List<R> lr = new ArrayList<R>();
    for ( Line line : l ) { 
        if ( line is a children ) {
            R r = new R();
            r.id = id;
            l.remove(0);
            r.children = createResource(l, line.id);                
            lr.add(r);
        }
    }
    return lr;
}