Exception expectedException = new Exception(...);
...
handlerMock.sendEmail(aryEq(userDetails));
EasyMock.expectLastCall().andThrow(expectedException);

EasyMock.replay(handlerMock);