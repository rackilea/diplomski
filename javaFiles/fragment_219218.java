toSet.retainAll(MaterialTypes.IMMOVABLE_TYPES);
for(MaterialTypes mt : fromSet) {
    if(!MaterialTypes.IMMOVABLE_TYPES.contains(mt))
        toSet.add(mt);
}

fromSet.retainAll(MaterialTypes.IMMOVABLE_TYPES);