$ cat f1.java
public class f1 {
  void f() {
    for(int i = 0 ; i < 99999;i++) {
      for(int j = 0 ; j < 99999;j++) {
      }
    }
  }
}

$ cat f2.java
public class f2 {
  void f() {
    int i, j;
    for(i = 0 ; i < 99999;i++) {
      for(j = 0 ; j < 99999;j++) {
      }
    }
  }
}