@Test
public void mockInternalDependency(@Mocked final Dependency anyDep)
{
    new NonStrictExpectations() {{ anyDep.getId(); result = "test"; }};

    new Sample().doSomethingWithTheDependency();

    new Verifications() {{
        // verify invocations to "anyDep" here, if needed
    }};
}