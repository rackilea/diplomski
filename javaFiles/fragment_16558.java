static class MyClassComparator implements Comparator<MyClass>
 {
     public int compare(MyClass c1, MyClass c2)
     {
         return c1.getPriority().compareTo(c2.getPriority());
     }
 }