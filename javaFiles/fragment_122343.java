filenames.map(Paths::get)
  .filter(Files::exists)
  .map(p -> {
        try {
            return Optional.of(Files.newBufferedReader(p));
        } catch (IOException e) {
            return Optional.empty();
        }
    }) 
 .filter(Optional::isPresent)
 .map(Optional::get)
 .flatMap(reader -> {
   try(Reader r = reader) {

      //read from your reader here and return the items to flatten

   } //reader is implicitly closed here
  })