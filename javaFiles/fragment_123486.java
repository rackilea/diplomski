public static ObjectA newObjectA(String param) {
    if (param == null) {
        return null;
    }

    ObjectB objB = new ObjectB(); // Occupied the memory required by for member variables of ObjectB along with the references
    ObjectA objA; // Occupy 4 bytes or 8 bytes as explained below.

    // do something else

    return objA;
}