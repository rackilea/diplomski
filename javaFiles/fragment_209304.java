@NameBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface UserInModel {
}


@Path("/")
public class IndexController {

    @GET
    @UserInModel
    @Produces(MediaType.TEXT_HTML)
    public Viewable home() {
        Map<String, Object> model = new HashMap<>();
        return new Viewable("/index", model);
    }
}