ArgumentCaptor<Runnable> runnableCaptor = ArgumentCaptor.for(Runnable.class);
verify(moqLoginPool).execute(runnableCaptor.capture());

verify(moqLoginService, never()).tryLogin(any(), any());
runnableCaptor.getValue().run();
verify(moqLoginService).tryLogin(any(), any());