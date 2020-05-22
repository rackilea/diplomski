chainListener = new JobChainingJobListener( "myChainListener" );
chainListener.addJobChainLink( job1.getKey(), job2.getKey() );

sched.scheduleJob( job1, trigger );
sched.addJob( job2, true );
sched.addGlobalJobListener( chainListener ); 
  sched.start();