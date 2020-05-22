public class MyClass {
    private List<String> originalList1 = new ArrayList<String>();
    private List<String> originalList2 = new ArrayList<String>();

    public void run() {
       this.test(originalList1, originalList2);
    }

    public void test(List<String> list1, List<String> list2) {
       list1 = new ArrayList<String>();
       list1.add(new String("Hello"));
       list2.add(new String("World"));
       System.out.println("list1.size -> " + list1.size());
       System.out.println("originalList1.size -> " + originalList1.size());
       System.out.println("list2.size -> " + list2.size());
       System.out.println("originalList2.size -> " + originalList2.size());
    }
  }