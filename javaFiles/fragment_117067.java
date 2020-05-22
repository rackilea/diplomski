@Conditional(MyCondition.class)
@Controller
public class Box{
   ...
}


public class MyCondition implements Condition{

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment env = context.getEnvironment();
        return null == env.getProperty("tokens.token[0].name");
    }
}