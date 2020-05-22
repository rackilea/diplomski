@Provider
@Singleton
public class ModelInjectableProvider extends AbstractHttpContextInjectable<Model> implements InjectableProvider<ModelParam, Type>
{
    private final Type type;

    public ModelInjectableProvider()
    {
        type = null;
    }

    public ModelInjectableProvider(Type type)
    {
        this.type = type;
    }

    @Override
    public ComponentScope getScope()
    {
        return ComponentScope.Undefined;
    }

    @Override
    public Injectable<Model> getInjectable(ComponentContext ic, ModelParam mp, Type type)
    {
        if (type instanceof Class && Model.class.isAssignableFrom((Class<?>) type))
        {
            return new ModelInjectableProvider(type);
        }

        return null;
    }

    @Override
    public Model getValue(HttpContext ctx)
    {
        if (type instanceof Class && Model.class.isAssignableFrom((Class<?>) type))
        {
            HttpRequestContext request = ctx.getRequest();

            Model model = null;

            if (HttpMethod.POST.equals(request.getMethod()) || HttpMethod.PUT.equals(request.getMethod()))
            {
                model = (Model) MyGuiceInjector.inject((Class<?>) type);

                if (model != null)
                    model = request.getEntity(model.getClass());
            }

            return model;
        }

        return null;
    }
}