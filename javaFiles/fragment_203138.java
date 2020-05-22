// arrange
Account acc = new Account();
RepositoryImpl repoSpy = Mockito.spy(new RepositoryImpl());

doReturn(acc).when(repoSpy).find(Mockito.any(String.class));

//act
repoSpy.register(acc);

// assert ..