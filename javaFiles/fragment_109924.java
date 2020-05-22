public class SimpleCollaborationSerializer extends JsonSerializer<Set<Collaboration>> {

    @Override
    public void serialize(final Set<Collaboration> collaborations, final JsonGenerator generator,
        final SerializerProvider provider) throws IOException, JsonProcessingException {
        final Set<SimpleCollaboration> simpleCollaborations = Sets.newHashSet();
        for (final Collaboration collaboration : collaborations) {
            simpleCollaborations.add(new SimpleCollaboration(collaboration.getId(), collaboration.getName()));                
        }
        generator.writeObject(simpleCollaborations);
    }

    static class SimpleCollaboration {

        private Long id;

        private String name;

        // constructors, getters/setters

    }

}