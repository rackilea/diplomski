@NamedNativeQuery(
    name = "my_query",
    query =
        "select {h-schema}PACKAGE_NAME.function( :param ) " +
        "from dual ",
    resultClass = MyResult.class
)