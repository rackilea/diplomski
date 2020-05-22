public class SendMailListener implements JobExecutionListener {

    final static Logger LOGGER = LoggerFactory.getLogger(SendMailListener.class);

    @Autowired // field injection is not recommended, use constructor injection instead
    private JobExplorer explorer;
    @Autowired // field injection is not recommended, use constructor injection instead
    private JavaMailSender javaMailSender;

    @Autowired
    private StepExecution stepExecution;

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            LOGGER.info("The job has been completed with the following parameters: " + jobExecution.getJobParameters());
        }
        //send email here
        MimeMessage message = javaMailSender.createMimeMessage();
        // set message properties (sender, receiver, content)
        javaMailSender.send(message);
    }

    @Override
    public void beforeJob(JobExecution jobExecution) {
        // TODO Auto-generated method stub
        //send email here
        MimeMessage message = javaMailSender.createMimeMessage();
        // set message properties (sender, receiver, content)
        javaMailSender.send(message);
    }

}