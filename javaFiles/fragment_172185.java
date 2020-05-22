@GeneratedValue(strategy=GenerationType.TABLE, generator="course")
        @TableGenerator(
                name="course",
                table="GENERATOR_TABLE",
                pkColumnName = "key",
                valueColumnName = "next",
                pkColumnValue="course",
                allocationSize=30
            )
    private int id;