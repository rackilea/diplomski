try{
    OozieClient wc = new OozieClient("http://host.com:11000/oozie");

    Properties conf = wc.createConfiguration();
    conf.setProperty(....)
    ...
    String jobId = wc.run(conf);
    System.out.println("Workflow job submitted");

    while (wc.getJobInfo(jobId).getStatus() == WorkflowJob.Status.RUNNING) {
       System.out.println("Workflow job running ...");
       Thread.sleep(10 * 1000);
    }
    System.out.println("Workflow job completed ...");


    System.out.println(wc.getJobInfo(jobId)); 
}catch(OozieClientException oozieClientException){
    oozieClientException.printStackTrace();
}