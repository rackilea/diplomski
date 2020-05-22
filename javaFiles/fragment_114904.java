Exception occurred = null;
try
{
    // Some action that is intended to produce an exception
}
catch (Exception exception)
{
    occurred = exception;
}
assertNotNull(occurred);
assertTrue(occurred instanceof /* desired exception type */);
assertEquals(/* expected message */, occurred.getMessage());