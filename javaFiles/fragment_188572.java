MockingDetails details = Mockito.mockingDetails(mock);
Collection<Invocation> invocations = details.getInvocations();

for(Invocation invocation: invocations){
   if(CollectionUtils.isNotEmpty(invocation.getRawArguments()){
      return;
   }
}

fail();