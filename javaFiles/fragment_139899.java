private static Map<List<String>, List<MyClass>> groupListBy(List<MyClass> data, String[] groupByFieldNames) {
    final MethodHandles.Lookup lookup = MethodHandles.lookup();
    List<MethodHandle> handles = 
        Arrays.stream(groupByFieldNames)
              .map(field -> {
                  try {
                      return lookup.findGetter(MyClass.class, field, String.class);
                  } catch (Exception e) {
                      throw new RuntimeException(e);
                  }
              }).collect(toList());
    return data.stream().collect(groupingBy(
            d -> handles.stream()
                        .map(handle -> {
                            try {
                                return (String) handle.invokeExact(d);
                            } catch (Throwable e) {
                                throw new RuntimeException(e);
                            }
                        }).collect(toList())
        ));
}