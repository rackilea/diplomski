mapper.setAnnotationIntrospector( new JacksonAnnotationIntrospector() {
            @Override
            public PropertyName findNameForSerialization(Annotated a) {
                return null;
            }
        });