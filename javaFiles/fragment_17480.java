// imports ommited for brevity
@Test
public void callbackIsCalled()
{
    final CallBack callBack = mock(CallBack.class);
    method(callBack);

    verify(callBack, only()).handle(any());
}