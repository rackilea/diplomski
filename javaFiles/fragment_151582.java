abstract class Answer<T> {
  public abstract T getAnswer();
}

public class StringAnswer extends Answer<String> {
  public String getAnswer() { ... }
}