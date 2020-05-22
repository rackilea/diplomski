module a {
    exports com.internal to a1;
    exports com.internal to a2;
}

module a1 {
    requires transitive a;
}

module a2 {
    requires transitive a;
}