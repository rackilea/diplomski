mapper.setAnnotationIntrospector(new IgnoreIntrospector());

mapper.setVisibility(mapper.getSerializationConfig().getDefaultVisibilityChecker()
.withFieldVisibility(JsonAutoDetect.Visibility.ANY)
.withGetterVisibility(JsonAutoDetect.Visibility.NONE)
.withSetterVisibility(JsonAutoDetect.Visibility.NONE)
.withCreatorVisibility(JsonAutoDetect.Visibility.NONE));

mapper.setVisibility(mapper.getDeserializationConfig().getDefaultVisibilityChecker()
.withFieldVisibility(JsonAutoDetect.Visibility.ANY)
.withGetterVisibility(JsonAutoDetect.Visibility.NONE)
.withSetterVisibility(JsonAutoDetect.Visibility.NONE)
.withCreatorVisibility(JsonAutoDetect.Visibility.NONE));