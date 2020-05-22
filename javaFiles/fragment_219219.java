toSet.retainAll(MaterialTypes.IMMOVABLE_TYPES);
for(Iterator<MaterialTypes> it = fromSet.iterator(); it.hasNext();) {
    MaterialTypes mt = it.next();
    if(!MaterialTypes.IMMOVABLE_TYPES.contains(mt)) {
        toSet.add(mt);
        it.remove();
    }
}