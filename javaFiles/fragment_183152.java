List<StringBuilder> stringBuilders = Arrays.stream(str.split(","))
    .map(s -> s.split("_"))
    .collect(
        () -> Arrays.asList(new StringBuilder(), new StringBuilder()),
        (List<StringBuilder> sb, String[] sa) -> {
            sb.get(0).append("'").append(sa[0]).append("',");
            sb.get(1).append("'").append(sa[1]).append("',");
        },
        List::addAll
    );

String ids = stringBuilders.get(0).toString();
String relids = stringBuilders.get(1).toString();