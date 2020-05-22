public class RequiresSetupCalculator {
  private static RequiresSetupCalculator instance;

  private int result = 0;
  private double result1 = 0;

  private boolean isSetup;

  private RequiresSetupCalculator() {
  }

  public static synchronized RequiresSetupCalculator setup() {
    if (instance == null) {
        instance = new RequiresSetupCalculator();
    }

    if (instance.isSetup) {
        throw new RuntimeException("I have already been set up");
    }

    instance.isSetup = true;

    return instance;
  }

  public void cleanUp() {
    if (!isSetup) {
        throw new RuntimeException("I wasn't set up in the first place");
    }

    isSetup = false;
  }

  public void add(final int arg1,
                final int arg2) {
    if (!isSetup) {
        throw new RuntimeException("I haven't been set up, no calculating for you!");
    }

    result = arg1 + arg2;
  }

  public int getResult() {
    if (!isSetup) {
        throw new RuntimeException("I haven't been set up, no calculating for you!");
    }

    return result;
  }

  public void subtract(final int arg1,
                     final int arg2) {
    if (!isSetup) {
        throw new RuntimeException("I haven't been set up, no calculating for you!");
    }

    result1 = arg2 - arg1;
  }

  public double getresult1() {
    if (!isSetup) {
        throw new RuntimeException("I haven't been set up, no calculating for you!");
    }

    return result1;
  }
}