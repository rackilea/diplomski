void foo(List<String> strings) {
  strings.stream()
      .map(
          a -> {
            String abc;
            abc = a.replace("a", "*");
            return abc;
          })
      .collect(Collectors.toList());
}

void bar(List<String> strings) {
  strings.stream().map(a -> a.replace("a", "*")).collect(Collectors.toList());
}