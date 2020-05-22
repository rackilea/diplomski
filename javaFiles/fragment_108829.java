@Id
@GenericGenerator(
        name = "sequenceGenerator",
        strategy = "enhanced-sequence",
        parameters = {
                @org.hibernate.annotations.Parameter(
                        name = "optimizer",
                        value = "pooled-lo"
                ),
                @org.hibernate.annotations.Parameter(
                        name = "initial_value",
                        value = "1"
                ),
                @org.hibernate.annotations.Parameter(
                        name = "increment_size",
                        value = "10"
                )
        }
)
@GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "sequenceGenerator"
)
@Column(name = "id", unique = true,updatable = false, nullable = false)
private Long id;