ReporterService reporterService1 = EasyMock.createMock(ReporterService.class);
Reporter reporter = EasyMock.createMock(Reporter.class);

Whitebox.setInternalState(reporterService , "reporter", reporter);
reporter.onStop();
PowerMock.expectLastCall();

EasyMock.replay(reporterService1,reporter);

reporterService1.onStop();

EasyMock.verify(reporterService1,reporter);