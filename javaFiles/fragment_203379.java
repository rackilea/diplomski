List<Entity> entities = 
    Files.lines(Paths.get(SOURCE_FILE))
         .skip(1) // skip the header line
         .map(line -> line.split(",")) // transform each line to an array
         .map(snippets -> new Entity(Integer.parseInt(snippets[ID]),
                                     snippets[NAME],
                                     Double.parseDouble(snippets[WEIGHT])) // transform each array to an entity
         .collect(Collectors.toList());