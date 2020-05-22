abstract class Measurable
{
   protected void abstract doWork();

   public void execute(){
     stopWatch = StopWatch.start();
     doWork();
     stopWatch.stop();
     System.out.println(stopWatch.getTime());
   }
}

class MyHttpClient extends Measurable
{
    doWork(){
        HttpResponse rs = HttpClientUtil.get("http://192.169.1.2:9090/plugins/restapi/v1/users/9223370580466120397/roster",RestOpenfire.ACCEPT, "8V9BUNA0f1gNQI3S");
    }
}

public static void main(String[] args) {

    MyHttpClient test=new MyHttpClient();
    test.execute();
}