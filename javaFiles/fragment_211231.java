public void test() {

  NamingEnumeration<? extends Attribute> enumeration = ...

  Attribute attributeMock = mock(Attribute.class);
  when(attributeMock.getAll()).thenReturn(enumeration);

  Attributes attributesMock = mock(Attributes.class);
  when(attributesMock.get(any(String.class)).thenReturn(attributeMock);

  MyMatcher matcher = new MyMatcher();
  matcher.mapFromAttributes(attr);

  // assert ... matcher.list
}