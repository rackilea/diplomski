static void generate(String prefix, String suffix) {
    int i = suffix.replaceAll("[aeiou].*", "").length();
    if (i == suffix.length()) {
        System.out.println(prefix + suffix);
    } else {
        generate(prefix + suffix.substring(0, i), suffix.substring(i + 1));
        generate(prefix + suffix.substring(0, i+1), suffix.substring(i + 1));
    }
}

// generate("", "apple");