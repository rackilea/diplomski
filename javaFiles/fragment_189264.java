boolean c1, c2, c3;

public void someMethod() {
  boolean ok = true;
  String err = "";

  if (ok && !(ok &= c1)) {
    err = "Specific Condition 1 Error";
  }

  if (ok && !(ok &= c2)) {
    err = "Specific Condition 2 Error";
  }

  if (ok && !(ok &= c3)) {
    err = "Specific Condition 3 Error";
  }

  if ( ok ) {
    doSomething();
  } else {
    System.out.print(err);
  }
}