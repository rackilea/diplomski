public Collection<String> test(Collection<String> strings) {
    return strings.stream()
            .filter(str -> str.length() >= 10)
            .map(str -> str.substring(str.length() / 2))
            .filter(s -> s.charAt(0) >= 'a')
            .map(String::toUpperCase)
            .collect(Collectors.toList());
}