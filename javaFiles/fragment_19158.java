public class Main {
  static Count count;

  ....

  public static void main(String[] args) {
    count = setupCounter();
    for (;;) {
      counterControl();
    }

  }

  public static Count setupCounter() {
    ...    
    return new Count(startVal, incrementVal);
  }