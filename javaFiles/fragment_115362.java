@Test
public void test(){
  Publisher publisher = Mockito.mock(Publisher.class);
  myMapper.setPublisher(publisher);
  ArgumentCaptor<MappedClass> captor = ArgumentCaptor.forClass(MappedClass.class);

  ....
  myMapper.handle(...);
  ...

  verify(publisher).publish(captor.capture());
  MappedClass passedValue = captor.getValue();
  // assert stuff here
}