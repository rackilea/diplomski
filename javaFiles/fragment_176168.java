package stackOverflow

import stackOverflow._

class ScalaByteReceiver{

  def receive(bytes: Array[Byte]) {    
    println(bytes.length);
    // prints 4
  }
}