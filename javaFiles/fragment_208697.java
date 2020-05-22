Custom mock = EasyMock.createMock(Custom.class); // create the mock
mock.process(EasyMock.anyObject(MyObject.class)); // invoke the method
EasyMock.expectLastCall(); // register it as expected
EasyMock.replay(mock); // set the state


mock.process(new MyObject()); // invoke the method in the test

EasyMock.verify(mock); // verify the call