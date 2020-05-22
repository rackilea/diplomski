when(mockedMergeContext.createNewEntityOfType(IService.class))
  .thenAnswer(new Answer<IService>() {
     public IService answer(InvocationOnMock invocation) {
        return new ServiceMock();
     }
   });