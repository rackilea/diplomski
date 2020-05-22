class Root {
    @JsonIgnore
    String fieldA;
}

class A extends Root {
    String fieldA;
    String fieldB;
}

class B extends Root {
    String fieldA;
    String fieldC;
}