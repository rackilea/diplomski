public class MyResourceConfig extends ResourceConfig
{
    public MyResourceConfig()
    {
        register(RestContextFilter.class);

        register(new AbstractBinder()
        {
            @Override
            protected void configure()
            {
                bindFactory(new Factory<RestContext>()
                {
                    @Override
                    public RestContext provide()
                    {
                        return new RestContext();
                    }

                    // this will get called at the end of the request
                    // allowing you to close your request scoped object
                    @Override
                    public void dispose(RestContext instance)
                    {
                        instance.close();
                    }
                }, RequestScoped.class).to(RestContext.class).in(RequestScoped.class);
            }
        });
    }
}