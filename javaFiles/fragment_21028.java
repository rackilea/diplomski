@InjectLink(
    rel = "self",
    type = "GET",
    resource = SomeResource.class,
    method = "someMethod",
    bindings = @Binding(name = "id", value = "${instance.id}"),
    style = Style.ABSOLUTE,
    condition = "${resource.isMethodRoleProtected(someMethod)}"
),