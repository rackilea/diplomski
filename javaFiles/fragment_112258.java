@Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "post_id",
            unique = true, nullable = false)
    @JsonView(Views.Public.class)
    private Integer postId;