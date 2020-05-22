// invented constants for example
public static final int HAS_BORDER = 1;   // in binary: 0b00000001
public static final int HAS_FRAME = 2;    //            0b00000010
public static final int HAS_TITLE = 4;    //            0b00000100

public void exampleMethod() {
  int flags = 0;                          //    flags = 0b00000000
  flags |= HAS_BORDER;                    //            0b00000001
  flags |= HAS_TITLE;                     //            0b00000101

  if ((flags & HAS_BORDER) != 0) {
    // do x
  }

  if ((flags & HAS_TITLE) != 0) {
    // do y
  }
}