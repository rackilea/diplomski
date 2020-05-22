myObject.doSomeStuff();

verify(myMockedOtherObject, never()).someMethodOrOther(
    Mockito.anyString(),
    Mockito.anyString()
);