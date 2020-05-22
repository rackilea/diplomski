private Predicate<Objt1> getLocalAttributesPredicate() {
    return input -> cache.get(input.getAttributeID())
            .stream()
            .map(group -> group.getAttributeGroupID())
            .filter(id -> id.equals(localAttrGroupId))
            .filter(id -> !id.equals(exclustionAttrGroupId))
            .limit(1)
            .count() > 0;
}