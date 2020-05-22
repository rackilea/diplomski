...
@Autowired  // This should work as a request has an implicit session
private ISubmissionDao submissionDao;

@Autowired  // This should also work: the request thread should have a thread-scoped exportThread
private GenerateExportThread generateExportThread;

...
generateExportThread.setSubmissionDao(submissionDao);
String result = generateExportThread.call(); // Or whatever you use to run this thread