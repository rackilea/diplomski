@Singleton public class MyUtilWrapper {

  private MyUtil myUtil;

  @Inject public MyUtilWrapper(MyUtil myUtil) {
    this.myUtil = myUtil;
  }

}