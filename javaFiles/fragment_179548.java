@GenericGenerator(
        name = "wikiSequenceGenerator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @Parameter(name = "sequence_name", value = "WIKI_SEQUENCE"),
                @Parameter(name = "initial_value", value = "1000"),
                @Parameter(name = "increment_size", value = "1")
        }
)
@Id
@GeneratedValue(generator = "wikiSequenceGenerator")