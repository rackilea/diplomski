public static <X> ParameterDefinition<X> build(Class<X> type, String name) { ... }

@SuppressWarnings({"unchecked", "rawtypes"})
public static <X> Class<List<X>> listOf(Class<X> itemType) {
    return (Class) List.class;
}

static ParameterDefinition<String> = build(String.class, "name");
static ParameterDefinition<List<String>> = build(listOf(String.class), "keywords");