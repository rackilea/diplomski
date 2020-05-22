@Table(name = "the_name_of_your_table")
public class YourClass {

  @column(name = "the_column_name")
  @Enumerated(EnumType.STRING) // <-Tells JPA to store the enum as a String
  private Status status; 

}