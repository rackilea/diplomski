int longest = list.stream()
                  .mapToInt(String::length)
                  .max()
                  .orElse(-1);

List<String> result = list.stream()
                          .filter(s -> s.length() == longest)
                          .collect(toList());