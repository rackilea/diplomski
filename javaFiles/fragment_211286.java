ReportCollector reportData = Mockito.mock(ReportCollector.class);
Sendable sendable = Mockito.mock(Sendable.class);
Mockito.when(reportData.collect()).thenReturn(sendable);

BasicReportManager basicReportManager = new BasicReportManager("1", reportData);

// now your test invocation on BasicReportManager will use the mocked instance of ReportCollector