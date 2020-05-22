@Id
    @TableGenerator(name = "addition_type_id_seq", allocationSize = 1, table = "ADDITION_TYPE_SEQUENCES",
                pkColumnName = "SEQ_NAME",
                        valueColumnName = "SEQ_NUMBER",
                pkColumnValue = "SEQUENCE")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "addition_type_id_seq")
    @Column(name = "id")
    private int id;