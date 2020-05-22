class OsSpecificExecutor implements Executor{
     private IExecutorService ex;


     public void execute(Runnable task){
         Set<Member> targetMembers = getYourTargetMembers()
         Member member = random(targetMembers)
         ex.executeOnMember(task, member);
     }
 }