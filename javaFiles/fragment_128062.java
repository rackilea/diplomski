if (fieldType == List.class) {
    // here I would like to change information of the lists objects
    logger.info("## My List: " + field.get(o));
    List items = (List) field.get(o)
    for(Object item : items) {
        observeAndReflect(item);
    }
}