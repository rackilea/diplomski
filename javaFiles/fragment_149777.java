public class X {
  Variable v = new Variable();
  [... here is something done with v]

  class Y { 
    Variable v_new = v;
    [works with v]
    public Variable getV() { return v_new; }
  }

  Y y = new Y();
  v = y.getV();
}