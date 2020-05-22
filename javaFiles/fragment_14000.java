for (String test : Arrays.asList("Fondation_Alliance_fran%C3%A7aise",
    "Anv%E4ndare")) {
  String result = parse(test, StandardCharsets.UTF_8,
      StandardCharsets.ISO_8859_1);
  System.out.println(result);
}