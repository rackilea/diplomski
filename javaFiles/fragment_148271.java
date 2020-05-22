final TagMaker tagMaker = getTagMaker(object.getClass()); //implied cast TagMaker<? super ?> -> TagMaker
if (tagMaker != null) {
    @SuppressWarnings("unchecked")
    final Tag tag = tagMaker.makeTag(name, object);
    return tag;
}