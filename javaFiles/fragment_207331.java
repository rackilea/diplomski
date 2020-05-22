Iterator<Obj> it = // Get your iterator from your resource
ArrayList<Obj> result = new ArrayList<Obj>(1);
if(it.hasNext()) {
    result.add(it.next());
}
if(it.hasNext()) {
    result.ensureCapacity(100);// Avg size of the Y group
    while(it.hasNext()) {
        result.add(it.next());
    }
}