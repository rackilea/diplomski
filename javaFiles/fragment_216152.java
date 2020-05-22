for (Example foo : Util.getExample(new TypeToken<List<Example>>() {}) {
    // do stuff
} 

// utils
public <T> T getExample(TypeToken<T> typeToken) {
    Type type = typeToken.getType();
    // get example
}