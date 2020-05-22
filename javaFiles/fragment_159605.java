@GeneratedValue(generator = SEQUENCE_GENERATOR)
@GenericGenerator(name = SEQUENCE_GENERATOR,
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
        @Parameter(name = "sequence_name", value = "my_sequence"),
        @Parameter(name = "initial_value", value = "1001"),
        @Parameter(name = "increment_size", value = "1"),
        @Parameter(name = "value_column", value = "my_squence_id") })