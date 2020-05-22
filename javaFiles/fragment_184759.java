scala> class IsPrimitiveChar {
     |   def myChar(i: Int): Char = i.toChar   // I am clearly a Char, whatever that is!
     | }
defined class IsPrimitiveChar

scala> :javap IsPrimitveChar
Compiled from "<console>"
public class IsPrimitiveChar extends java.lang.Object implements scala.ScalaObject{
    public char myChar(int);  // Look, it returns a char!
    public IsPrimitiveChar();
}


scala> :javap -c -private IsPrimitiveChar
Compiled from "<console>"
public class IsPrimitiveChar extends java.lang.Object implements scala.ScalaObject{
public char myChar(int);
  Code:
   0:   iload_1
   1:   i2c               // Look, primitive int to char conversion in bytecode!
   2:   ireturn           // And that's all!