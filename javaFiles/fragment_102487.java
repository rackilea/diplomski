public class MyRunnerListener extends RunListener {
    private Context context;

    public MyRunnerListener(Context context) {
        this.context = context;
    }

     void   testRunFinished(Result result)  {
          context.close();
     }
}