@Scheduled(fixedRate=30000)
public void scheduledMethod () {
    try{
        MDC.put("scheduled", "true");

        // Your code here
    }finally{
        MDC.remove("scheduled");
    }
}