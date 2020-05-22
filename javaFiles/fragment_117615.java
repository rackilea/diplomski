Set<String> diff1 = source.stream().filter(str -> {
    if (str.length() > 10) {
        String account = str.substring(0, 10);
        return noRek.contains(account);
    }
    return false;
}).collect(Collectors.toSet());