@SwaggerDefinition(
  info = @Info(
    title = "My API",
    version = "0.1",
    contact = @Contact(name = "Me", email = "me@myself.com")
  ),
  tags = {
   @Tag(
     name = "pets", description = "Manage pets"
   ), @Tag(
     name = "search", description= "Search pets"
   ), ...
  }
)
public class BaseResource {
...
}