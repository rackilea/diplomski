class MySUT
{
    private final Collection<Object> objects = new ArrayList<>();
    public MySUT(Object firstObject)
    {
        objects.add(firstObject);
    }

    public void addNewObject(Collection<Object> other, Object newObject)
    {
        other.removeAll(objects);
        objects.clear();

        objects.add(newObject);
        other.addAll(objects);
    }
}

@Test
public void test()
{
    Object firstObject = mock(Object.class);
    Object newObject = mock(Object.class);
    Collection<Object> myObject = mock(Collection.class);

    MySUT sut = new MySUT(firstObject);

    final List<Object> removeAllResult = new ArrayList<>();
    when(myObject.removeAll(anyCollectionOf(Object.class))).thenAnswer(new Answer<Object>()
    {
        @Override
        public Object answer(InvocationOnMock invocation) throws Throwable
        {
            removeAllResult.addAll((Collection<Object>) invocation.getArguments()[0]);
            return null;
        }
    });

    sut.addNewObject(myObject, newObject);

    verify(myObject).removeAll(anyCollectionOf(Object.class));
    verify(myObject).addAll(anyCollectionOf(Object.class));

    assertThat(removeAllResult.get(0), equalTo(firstObject));
}