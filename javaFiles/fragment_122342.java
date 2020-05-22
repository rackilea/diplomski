filenames.map(Paths::get)
  .filter(Files::exists)
  .map(p -> {
        try (Reader r = new BufferedReader(new FileReader(p))){

            Stream.of(r)
            .... //put here your stream code that uses the stream

        } catch (IOException e) {
            return Optional.empty();
        }
    }) //reader is implicitly closed here
 .... //terminal operation here