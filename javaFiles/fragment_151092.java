@Parameters
public static Collection<Object[]> testInputs()
{
    return Arrays.asList({
        {1, CoreMatchers.allOf( CoreMatchers.is(1), CustomMatchers.status(1) ) },
        {2, CoreMatchers.allOf( CoreMatchers.is(2), CustomMatchers.status(2) ) }
    });
}