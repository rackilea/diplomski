Supplier<Stream<String>> streamSupplier = new Supplier<Stream<String>>() {
     @Override
     public Stream<String> get() {
         return lines;
     }
 };