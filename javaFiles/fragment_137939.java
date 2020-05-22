public class CreateBarDto {
  @NotNull(groups = {MyFirstGrup.class}) 
  public Boolean field1;
  @NotEmpty(groups = {MyFirstGrup.class})
  public String field2;

  @NotNull public String fooId; // the foreign key to Foo
}