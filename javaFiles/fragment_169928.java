verify(MyMock).handleError(any(ICallBack.class), 
                           argThat(new ArgumentMatcher<BaseError> {
   @Override
   public boolean matches(Object baseError) {
     return ((BaseError) baseError).errorCode == 3;
   }
}));