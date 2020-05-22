public static interface MyInterface<T> {
    public T getId();

    public void setId(T id);
  }

  public static interface MyOtherInterface {
    public List<String> getTexts();

    public List<Integer> getNotes();
  }

  public abstract class MyAbstractClass<T> implements MyInterface<T>, MyOtherInterface {
    private List<String> texts;
    private List<Integer> notes;

    public List<String> getTexts() {
      return texts;
    }

    public List<Integer> getNotes() {
      return notes;
    }
  }

  public static class MyConcreteClass extends MyAbstractClass<Integer> {
    private Integer id;

    public Integer getId() {
      return this.id;
    }

    public void setId(Integer id) {
      this.id = id;
    }
  }

  public class SomeOtherClass {
    public void process(MyOtherInterface myClass) {

      // NO Compilation error
      for (String str : myClass.getTexts()) {
        // some processing
      }
    }
  }