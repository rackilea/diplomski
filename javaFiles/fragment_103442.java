public class EComparator implements Comparator<ExampleClass> {

  public int compare(ExampleClass o1, ExampleClas o2) {
    return o1.getName().compareTo(o2.getName);
  }

}