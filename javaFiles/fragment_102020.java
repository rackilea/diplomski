@Autowired
protected PlatformTransactionManager transactionManager;

@Test
public void test() {

/*
 * ===================RUN JOB======================
 */
JobParameters jobParameters = new JobParametersBuilder();

int returnCode = runJob("job_name", jobParameters);
assertEquals("returnCode must be 0.", 0, returnCode );

/*
 * ===============END JOB=============================
 */

/*
 * ===============TEST ON DATA==========================
 */
(new TransactionTemplate(transactionManager)).execute(new TransactionCallback() {
        @Override
        public Object doInTransaction(TransactionStatus status) {

          ObjectToTest obj = objectDao.findById("1");

          assertNotNull( obj.getSomeCollection().get(1));
 }
});

/*
 * =================END TEST==================
 */




}