class SomeDto {
    private someField;


    @Column("PREVIOUS_FIELD_COLUMN", nullable = false, length = 1)
    @ColumnTransformer(read = “@NEW RETRIEVING LOGIC@”)
    public getSomeField() {
    ...
  }