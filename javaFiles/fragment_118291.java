public static void processElement(Object commonMapObjectEitherMapOrSet) {
    if (commonMapObjectEitherMapOrSet instanceof Map) {
        System.out.println("Got map; but types held in the map are not known due to type-erasure");

        // This is where things will get messy as you will get warnings:
        Map<String, List<Vo>> map = (Map<String, List<Vo>>) commonMapObjectEitherMapOrSet;
        // ...
    }

    if (commonMapObjectEitherMapOrSet instanceof Set) {
        System.out.println("Got set; but types held in the set are not known due to type-erasure");

        // This is where things will get messy as you will get warnings:
        Set<String> set = (Set<String>) commonMapObjectEitherMapOrSet;
        // ...

    }
}