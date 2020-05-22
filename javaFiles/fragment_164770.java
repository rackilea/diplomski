@Singleton public class MyUtil {

  private Application application;

  @Inject public MyUtil(Application application) {
    this.application = application;
  }

}