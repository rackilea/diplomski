@Test
   public void testMethod() throws Exception {
      DependentClass dependentClass = PowerMockito.mock(DependentClass.class);
      PowerMockito.whenNew(DependentClass.class).withNoArguments().thenReturn(dependentClass);

      Service service = new Service();
      service.method();
   }