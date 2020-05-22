@Namespace("/admin_side")
@ResultPath("/WEB-INF/content")
@InterceptorRefs({@InterceptorRef(value="defaultStack", params={"validation.validateAnnotatedMethodOnly", "true", "validation.excludeMethods", "load"})})
public final class TestAction  extends ActionSupport implements Serializable, ValidationAware, ModelDriven<Transporter>
{
    //...
}