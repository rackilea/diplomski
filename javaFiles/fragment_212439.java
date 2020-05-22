package bytecodetests;

import java.io.IOException;
import java.io.PrintWriter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.util.ASMifier;
import org.objectweb.asm.util.TraceClassVisitor;

public class BytecodeTests {

  public static void main(String[] args) throws IOException {
    new ClassReader(BytecodeTests.class.getResourceAsStream("BytecodeTests.class"))
      .accept(new TraceClassVisitor(null, new ASMifier(), new PrintWriter(System.out)), 0);
  }

}