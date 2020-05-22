...
    import static org.junit.Assert.assertEquals;
    import static org.powermock.api.mockito.PowerMockito.mockStatic;
    ...

    @PrepareForTest({ UUID.class })
    @RunWith(PowerMockRunner.class)
    public class ATest
    {
    ...
      //at some point in your test case you need to create a static mock
      mockStatic(UUID.class);
      when(UUID.randomUUID()).thenReturn("your-UUID");
    ...
    }