SparkSession spark = SparkSession.builder().appName("CSV to Dataset").master("local").getOrCreate();
    Encoder<FileFormat> fileFormatEncoder = Encoders.bean(FileFormat.class);
    Dataset<FileFormat> rawFile = spark.read() //
                                       .format("csv") //
                                       .option("inferSchema", "true") //
                                       .option("header", "true") // first line has headers
                                       .load("src/test/resources/encoding-tests/persons.csv") //
                                       .as(fileFormatEncoder);

    LOG.info("=============== Print schema =============");
    rawFile.printSchema();
    LOG.info("================ Print data ==============");
    rawFile.show();
    LOG.info("================ Print name ==============");
    rawFile.select("name").show();

    // when
    final SerializableFunction<String, List<Address>> asAddress = (String text) -> Arrays
            .stream(text.split(Pattern.quote("||"), -1)) //
            .map(object -> object.split("~")) //
            .map(Address::fromArgs) //
            .map(a -> a.orElse(null)).collect(Collectors.toList());

    final MapFunction<FileFormat, Person> personMapper = (MapFunction<FileFormat, Person>) row -> new Person(row.name,
                                                                                                             row.age,
                                                                                                             asAddress
                                                                                                                     .apply(row.address));
    final Encoder<Person> personEncoder = Encoders.bean(Person.class);
    Dataset<Person> persons = rawFile.map(personMapper, personEncoder);
    persons.show();

    // then
    assertThat(persons.isEmpty(), is(false));
    assertThat(persons.count(), is(2L));
    final List<String> names = persons.select("name").as(Encoders.STRING()).collectAsList();
    assertThat(names, hasItems("name1", "name2"));
    final List<Integer> ages = persons.select("age").as(Encoders.INT()).collectAsList();
    assertThat(ages, hasItems(10, 20));
    final Encoder<Address> addressEncoder = Encoders.bean(Address.class);
    final MapFunction<Person, Address> firstAddressMapper = (MapFunction<Person, Address>) person -> person.addresses.get(0);
    final List<Address> addresses = persons.map(firstAddressMapper, addressEncoder).collectAsList();
    assertThat(addresses, hasItems(new Address("streetA", "cityA"), new Address("streetC", "cityC")));