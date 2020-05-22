@JacksonAnnotationsInside
@JsonSerialize(using = IdToTokenSerializer.class) 
@JsonDeserialize(using = TokenToIdDeserializer.class)
@Retention(RetentionPolicy.RUNTIME)
public static @interface TokenizedId {
    Class<?> value();
}