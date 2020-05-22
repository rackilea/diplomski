public class Main {

  public static void main(String[] args) {
    Main main = new Main();

    IResult<String> result = new PrintCurrentThreadAndResult();
    main.doXYZ(result);

    IResult<String> uiThreadAwareResult = new UIThreadAwareResult<String>(result);
    main.doXYZ(uiThreadAwareResult);
  }

  public void doXYZ(IResult<String> iResult) {
    iResult.onResult("Hello");
  }
}