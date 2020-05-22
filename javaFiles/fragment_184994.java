public final class CustomReflectiveTypeAdapterFactory implements TypeAdapterFactory {
  private final ConstructorConstructor constructorConstructor;
  private final FieldNamingStrategy fieldNamingPolicy;
  private final Excluder excluder;

  public CustomReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor,
      FieldNamingStrategy fieldNamingPolicy, Excluder excluder) {
    this.constructorConstructor = constructorConstructor;
    this.fieldNamingPolicy = fieldNamingPolicy;
    this.excluder = excluder;
  }

  public boolean excludeField(Field f, boolean serialize) {
    return !excluder.excludeClass(f.getType(), serialize) && !excluder.excludeField(f, serialize);
  }

  private String getFieldName(Field f) {
    SerializedName serializedName = f.getAnnotation(SerializedName.class);
    return serializedName == null ? fieldNamingPolicy.translateName(f) : serializedName.value();
  }

  public <T> TypeAdapter<T> create(Gson gson, final TypeToken<T> type) {
    Class<? super T> raw = type.getRawType();

    if (!Object.class.isAssignableFrom(raw)) {
      return null; // it's a primitive!
    }

    ObjectConstructor<T> constructor = constructorConstructor.get(type);
    return new Adapter<T>(constructor, getBoundFields(gson, type, raw));
  }

  private CustomReflectiveTypeAdapterFactory.BoundField createBoundField(
      final Gson context, final Field field, final String name,
      final TypeToken<?> fieldType, boolean serialize, boolean deserialize) {
    final boolean isPrimitive = Primitives.isPrimitive(fieldType.getRawType());

    // special casing primitives here saves ~5% on Android...
    return new CustomReflectiveTypeAdapterFactory.BoundField(name, serialize, deserialize) {
      final TypeAdapter<?> typeAdapter = context.getAdapter(fieldType);
      @SuppressWarnings({"unchecked", "rawtypes"}) // the type adapter and field type always agree
      @Override void write(JsonWriter writer, Object value)
          throws IOException, IllegalAccessException {
        Object fieldValue = field.get(value);
        TypeAdapter t =
          new CustomTypeAdapterRuntimeTypeWrapper(context, this.typeAdapter, fieldType.getType());
        t.write(writer, fieldValue);
      }
      @Override void read(JsonReader reader, Object value)
          throws IOException, IllegalAccessException {
    Object fieldValue = null;
      try {
            fieldValue = typeAdapter.read(reader);
      } catch (GsonEnumParsinException e){
        e.setFieldName(field.getName());
        throw e;        
      }
        if (fieldValue != null || !isPrimitive) {
          field.set(value, fieldValue);
        }
      }
    };
  }
  // more copy&paste code follows