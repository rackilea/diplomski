public interface A<T extends Observer & Comparable<? super T>>  {
  List<? extends B> bList();
  T observer();
}

B b = deep_stubbed.bList().iterator().next(); // returns a mock of B ; mockito remebers that A returns a List of B
Observer o = deep_stubbed.observer(); // mockito can find that T super type is Observer
Comparable<? super T> c = deep_stubbed.observer(); // or that T implements Comparable