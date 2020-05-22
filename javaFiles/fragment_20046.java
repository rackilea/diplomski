package test;

import static test.Outer.Inner.CONST;
import java.util.Iterator;

class Outer {
  interface Inner extends Iterator {
    static String CONST = "CONST";
  }
}