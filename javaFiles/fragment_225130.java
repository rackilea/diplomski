abstract class BaseUnitTesterWithSut<TSut>
{
    protected SystemUnderTestFactory<TSut> SutFactory;

    @Before
    public void before()
    {
        ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
        SutFactory = new SystemUnderTestFactory<>((Class<TSut>) thisType.getActualTypeArguments()[0]);
    }
}