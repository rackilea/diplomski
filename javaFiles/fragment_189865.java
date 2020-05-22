@SuppressWarnings("unchecked")
public static <T> T castToGeneric(Object objectToCast) {
    return (T)objectToCast;
}

// usage

Object someObject = null /* initialised elsewhere */;
Class<ArrayList<String>> listOfStrings = <Class<ArrayList<String>>>castToGeneric(someObject);