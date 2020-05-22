public abstract Dao {
    protected DataSource dataSource;
    protected SomeHelper someHelper;

    //setters
}

public class FooDao extends Dao {
    private FooHelper fooHelper;

    //setters
}

public class BarDao extends Dao {
    private BarHelper barHelper;

    //setters
}