Consumer<List<String>> handleTexture = args -> textures.add(parseTexture(args))
Consumer<List<String>> handleVertice = args -> vertices.add(parseVertice(args))
...
Map<String, Consumer<List<String>> handlers = new HashMap<>();
handlers.put("vf", handleTexture);
handlers.put("v", handleVertice);
...

for (final String line : lines) {
      final List<String> lineElements = Arrays.asList(line.split(" "));
      final String token = lineElements.get(0);
      handlers.get(token).accept(lineElements.sublist(1, lineElements.size()));)
}