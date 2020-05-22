@SqlResultSetMapping(
  name = "Account.getWithTemporalAttributes",
  classes = {
    @ConstructorResult(
      targetClass = com.company.domain.AccountTemporalDetails.class,
      columns = {
        @ColumnResult(name = "col1"),
        @ColumnResult(name = "col2")
      })
  })