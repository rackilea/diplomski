public interface ArgumentValidator<X> {

    boolean accept(Object o)

}

public static <X> ArgumentValidator<X> instanceOf(Class<X> type) { ... }

public static <X> ArgumentValidator<List<X>> listOf(Class<X> itemType) { ... }

public static <X> ParameterDefinition<X> build(ArgumentValidator<X> validator, String name) { ... }

public static <X> ParameterDefinition<X> build(Class<X> type, String name) {
    return build(instanceOf(type), name);
}

static ParameterDefinition<String> = build(String.class, "name");
static ParameterDefinition<List<String>> = build(listOf(String.class), "keywords");