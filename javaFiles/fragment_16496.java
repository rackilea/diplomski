public class Attrs {
    public static final TypedKey<User> USER = TypedKey.<User>create("user");
}

public class PassArgAction extends play.mvc.Action.Simple {
    public CompletionStage<Result> call(Http.Request req) {
        return delegate.call(req.addAttr(Attrs.USER, User.findById(1234)));
    }
}