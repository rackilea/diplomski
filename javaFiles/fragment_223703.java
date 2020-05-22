List<ExampleDTO> exampleDTOs = ...;
List<String> names = FluentIterable.from(exampleDTOs)
   .transform(new Function<ExampleDTO, String>() {
       @Override
       public String apply(ExampleDTO dto) {
           return dto.getName();
       }
   })
   .toList();