class Foo {
  static class PiHolder {
    static final Pi PI_SINGLETON;
    static Bar exception;
    static { 
      try { 
        PI_SINGLETON =  = getPi(); }
      } catch (Bar b) {
        exception = b;
      }
    }
  }
public Pi bar() throws Bar {
  if(PiHolder.exception!=null)
    throw PiHolder.exception;  
  else
    return PiHolder.PI_SINGLETON;
}