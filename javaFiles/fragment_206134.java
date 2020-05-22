EasyMock.replay(mock); // setting replay state to a mock object

// stripping proxy and getting the invocation handler
InvocationHandler invocationHandler = Proxy.getInvocationHandler(mock); 


// for easyMock, invocation handler holds the state of the mock 
ObjectMethodsFilter objectMethodsFilter = (ObjectMethodsFilter) invocationHandler; 

// not the not so elegant part:
// this: objectMethodsFilter.getDelegate().getControl().getState() 
// retrieves  the state instance that can be checked if it is an 
// instance of ReplayState.class
boolean inReplayState = objectMethodsFilter.getDelegate()
    .getControl().getState() instanceof ReplayState;