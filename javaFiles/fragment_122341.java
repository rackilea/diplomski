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
  .flatMap(r -> new ReaderTuple(r, yourOtherItem))
  ....
  .peek(rt -> {
    try { 
      rt.first.close()  //close the reader or use a try-with-resources
    } catch(Exception e){}
   })
  ...