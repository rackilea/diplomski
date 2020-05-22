static void method (List<? extends SuperC1> list) {

}

public static void main (String[] args) {
  List<A> list = new ArrayList<>();

  method(list);
}