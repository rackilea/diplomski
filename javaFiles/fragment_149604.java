@SpringBootApplication
public class KafkaStreamJoinApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaStreamJoinApplication.class, args);
    }

    @EnableBinding(KStreamProcessorX.class)
    public static class KafkaKStreamJoinApplication {

        @StreamListener
        public void process(@Input("school") KStream<SchoolKey, School> schools) {
            // replace map() with transform()
            schools.transform(new TransformerSupplier<SchoolKey, School, KeyValue<PersonKey, Person>>() {
                @Override
                public Transformer<SchoolKey, School, KeyValue<PersonKey, Person>> get() {
                    return new Transformer<SchoolKey, School, KeyValue<PersonKey, Person>>() {
                        ProcessorContext context;

                        @Override
                        public void init(final ProcessorContext context) {
                            this.context = context;
                        }

                        @Override
                        public KeyValue<PersonKey, Person> transform(final SchoolKey key, final School value) {
                            // clear all headers; would be sufficient to only remove type header
                            for (Header h : context.headers().toArray()) {
                                context.headers().remove(h.key());
                            }
                            // same a "old" map code:
                            return KeyValue.pair(new PersonKey("Adam", "Smith", key.getId()), new Person(12));
                        }

                        @Override
                        public void close() {}
                    };
                }})
                .through("person", Produced.with(new PersonKeySerde(), new PersonSerde()));
        }

        @StreamListener
        public void process1(@Input("school_1") KStream<SchoolKey, School> schools, @Input("person") KStream<PersonKey, Person> persons) {

            // replace selectKey() with transform()
            schools.transform(new TransformerSupplier<SchoolKey, School, KeyValue<Integer, School>>() {
                @Override
                public Transformer<SchoolKey, School, KeyValue<Integer, School>> get() {
                    return new Transformer<SchoolKey, School, KeyValue<Integer, School>>() {
                        ProcessorContext context;

                        @Override
                        public void init(final ProcessorContext context) {
                            this.context = context;
                        }

                        @Override
                        public KeyValue<Integer, School> transform(final SchoolKey key, final School value) {
                            // clear all headers; would be sufficient to only remove type header
                            for (Header h : context.headers().toArray()) {
                                context.headers().remove(h.key());
                            }
                            // effectively the same as "old" selectKey code:
                            return KeyValue.pair(key.getId(), value);
                        }

                        @Override
                        public void close() {}
                    };
                }})
                // replace selectKey() with transform()
                .join(persons.transform(new TransformerSupplier<PersonKey, Person, KeyValue<Integer, Person>>() {
                    @Override
                    public Transformer<PersonKey, Person, KeyValue<Integer, Person>> get() {
                        return new Transformer<PersonKey, Person, KeyValue<Integer, Person>>() {
                            ProcessorContext context;

                            @Override
                            public void init(final ProcessorContext context) {
                                this.context = context;
                            }

                            @Override
                            public KeyValue<Integer, Person> transform(final PersonKey key, final Person value) {
                                // clear all headers; would be sufficient to only remove type header
                                for (Header h : context.headers().toArray()) {
                                    context.headers().remove(h.key());
                                }
                                // effectively same as "old" selectKey code:
                                return KeyValue.pair(key.getId(), value);
                            }

                            @Override
                            public void close() {}
                        };
                    }}),
                    (school, person) -> {
                        System.out.println("school_app2= " + school + ", person_app2= " + person);
                        return null;
                    },
                    JoinWindows.of(Duration.ofSeconds(1)),
                    Joined.with(Serdes.Integer(), new SchoolSerde(), new PersonSerde())
                );
        }
    }

    interface KStreamProcessorX {
        @Input("person")
        KStream<?, ?> inputPersonKStream();

        @Input("school")
        KStream<?, ?> inputSchoolKStream();

        @Input("school_1")
        KStream<?, ?> inputSchool1KStream();
    }
}