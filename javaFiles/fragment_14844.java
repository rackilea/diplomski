public static MyEnum fromString(String text) {
        return Arrays.stream(values())
          .filter(v -> v.name().equalsIgnoreCase(text))
          .findFirst()
          .orElse(null);
    }
}