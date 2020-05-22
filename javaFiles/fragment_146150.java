private Long id;
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "x.y.z.LongGenerator")
    @Column(nullable = false, name = "id")
    public Long getId() {
        return id;
    }