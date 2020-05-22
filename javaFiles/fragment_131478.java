class SortedSetJsonSerializer extends JsonSerializer<Set> {

    @Override
    public void serialize(Set set, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (set == null) {
            gen.writeNull();
            return;
        }

        gen.writeStartArray();
        if (!set.isEmpty()) {
            // create sorted set only if it itself is not already SortedSet
            if (!SortedSet.class.isAssignableFrom(set.getClass())) {
                Object item = set.iterator().next();
                if (Comparable.class.isAssignableFrom(item.getClass())) {
                    // and only if items are Comparable
                    set = new TreeSet(set);
                }
            }
            for (Object item : set) {
                gen.writeObject(item);
            }
        }
        gen.writeEndArray();
    }
}