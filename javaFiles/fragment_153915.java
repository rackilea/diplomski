public void toString_returnsStringWithSuperClassToStringEmbedded()
{
    SomeClass classUnderTest = new SomeClass();

    assertThat(classUnderTest.toString(), contains("This is super's toString"));
}