@Bean
public JsonItemReader<Person> jsonItemReader(Resources[] resources) {
   JsonItemReader<Person> delegate = new JsonItemReaderBuilder<Person>()
      .jsonObjectReader(new JacksonJsonObjectReader<>(Person.class))
      .name("personItemReader")
      .build();

   MultiResourceItemReader<Person> reader = new MultiResourceItemReader<Person>();
   reader.setDelegate(delegate);
   reader.setResources(resources);
   return reader;
}