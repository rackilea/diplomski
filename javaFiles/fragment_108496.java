public void makeApiCall(String ip){
    Long currentTime=Timestamp timestamp = System.currentTimeMillis();

    String key=ip+":"+currentTime;

    redisClient.watch(key);
    Integer count=redisClient.get(key);

    if(count!=null && count > 10){
         throw LimitExceededException();
    }
    else{
         Transaction t = redisClient.multi();
         t.incr(key,1);
         List<Object> resp = t.exec();
         if(resp != null){
             callApi();
         }
    }
}