RealFactory factory     = new RealFactory();
RealFactory spy         = spy(factory);
TestedClass testedClass = new TestedClass(spy);

// At this point I would like to get a reference to the object created
// and returned by the factory.


// let's capture the return values from spy.create()
ResultCaptor<RealThing> resultCaptor = new ResultCaptor<>();
doAnswer(resultCaptor).when(spy).create();

// do something that will trigger a call to the factory
testedClass.doSomething();

// validate the return object
assertThat(resultCaptor.getResult())
        .isNotNull()
        .isInstanceOf(RealThing.class);