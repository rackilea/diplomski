TypeSpec spec = TypeSpec.classBuilder("SomeResource")
            .addAnnotation(
                    AnnotationSpec.builder(RequestMapping.class)
                    .addMember("value", "$S", "/api")
                    .build())
            .build();