// mock and make sure all fields required for modify are set
SomeType arg = create(); 
ArgumentCaptor<SomeType> captor = ArgumentCaptor. forClass(SomeType.class);

sut.process(arg) ;

verify (nextClass). process(captor.capture());
SomeType modified = captor.get();