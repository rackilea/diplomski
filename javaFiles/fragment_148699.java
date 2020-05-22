@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hilo_generator")
@GenericGenerator(
        name = "hilo_generator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                // Or leave it out to get "hibernate_sequence".
                @Parameter(name = "sequence_name", value = "hilo_sequence"),
                // Or leave it out as this is the default.
                @Parameter(name = "initial_value", value = "1"),
                @Parameter(name = "increment_size", value = "5"),
                @Parameter(name = "optimizer", value = "hilo")
        })