@ManyToOne
@JoinColumn(
    name = "cat_name", 
    foreignKey = @ForeingKey(
        name = "fk_child_category",
        foreignKeyDefinition = "FOREIGN KEY (cat_name) REFERENCES category ON UPDATE CASCADE"
    )
)
private Category category;