@Test
  public void testSomeVoidMethod() {

   PowerMockito.mockStatic(Person.class);

   Person.someVoidMethod();
   PowerMockito.verifyStatic(Person.class,Mockito.times(6));
   Person.someVoidMethod();


  }

}