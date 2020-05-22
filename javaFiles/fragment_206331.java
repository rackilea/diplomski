try (Context context = Context.create("js")) {
    Map<String, Object> myObject = new HashMap<>();
    myObject.put("foo", "bar");
    context.getBindings("js").putMember("hostObject", ProxyObject.fromMap(myObject));
    assert "bar".equals(context.eval("js", "hostObject.foo").asString());
    myObject.put("foo", "baz");
    assert "baz".equals(context.eval("js", "hostObject.foo").asString());
}