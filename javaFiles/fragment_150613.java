@Test
public void testMyMethod(){
    // given
    MyDomainClass myObj = new MyDomainClass();
    when(myDao.load(anyInt())).thenReturn(myObj);

    AtomicReference<MyDomainClass> actualSavedInstance = new AtomicReference<>();

    doAnswer(invocation -> {
        MyDomainClass supplied = (MyDomainClass) invocation.getArguments()[0];

        // copy/clone state from supplied - which represents the instance passed to save - into a separate
        // instance which can be used for an assertion
        MyDomainClass actual = new MyDomainClass();
        actual.myInt = supplied.myInt;
        actualSavedInstance.set(actual);
        return null;
    }).when(myDao).save(myObj);

    // when
    myApp.myMethod();

    assertThat(actualSavedInstance.get().myInt, is(0));
}