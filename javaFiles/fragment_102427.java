final String input = "a0Ba";

final int answer = Arrays.stream(input.split("[0-9]+"))
    .filter(s -> s.matches("(.+)?[A-Z](.+)?"))
    .sorted((s1, s2) -> s2.length() - s1.length())
    .findFirst()
    .orElse("")
    .length();

out.println(answer);