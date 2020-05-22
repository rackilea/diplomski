public class Pair<F,S>
{
  F first;
  S second;
  public Pair (F first, S second) {
    this.first=first;
    this.second=second;
  }
  public static <F,S> Pair<F,S> create (F first, S second) {
    return new Pair<F,S> (first,second);
  }
}

public class Event<T> {
  protected String name;
  protected Pair<String, T> event;

  public String getName() {
    return event.first;
  }

  public T getData() {
    return event.second;
  }

  public Event(String name, T data) {
    event = Pair.create (name, data); // note you can use the Pair constructor directly 
                                      // instead of calling the static create method
  }
}