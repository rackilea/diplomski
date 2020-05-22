static void generate(StringBuilder sb, String[] parts, int i) {
    if (i == parts.length) {
        System.out.println(sb.toString());
    } else {
        if ("aeiou".contains(parts[i])) {
            generate(sb, parts, i + 1);
        }
        sb.append(parts[i]);
        generate(sb, parts, i + 1);
        sb.setLength(sb.length() - parts[i].length());
    }
}
static void generate(String s) {
    generate(
        new StringBuilder(),
        s.split("(?<=[aeiou])|(?=(?!^)[aeiou])"),
        0
    );
}

// generate("apple");