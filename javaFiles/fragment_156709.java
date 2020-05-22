@SuppressWarnings("unchecked")
public static <C> C mapJsonToObject(String jsonString, JavaType type) {
    // ... stuff ...
    return (C) parsedObject;
}

// Check answer comments on TypeFactory#collectionType deprecation
List<MyBean> result = mapJsonToObject("[]", TypeFactory.collectionType(ArrayList.class, MyBean.class));