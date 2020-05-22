// c:\java\src\ws\Adder.java
package ws;
import javax.jws.WebService;

@WebService
public class Adder {
 public double add( double value1, double value2 ) {
  return value1 + value2;
 }
}