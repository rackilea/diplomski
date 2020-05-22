import java.io.*;
import java.lang.instrument.Instrumentation;
import java.lang.management.ManagementFactory;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

// this API comes from the tools.jar of your JDK
import com.sun.tools.attach.*;

public class SelfAttacher {

  public static Instrumentation BACK_LINK;

  public static void main(String[] args) throws Exception {
 // create a special property to verify our JVM connection
    String magic=UUID.randomUUID().toString()+'/'+System.nanoTime();
    System.setProperty("magic", magic);
 // the easiest way uses the non-standardized runtime name string
    String name=ManagementFactory.getRuntimeMXBean().getName();
    int ix=name.indexOf('@');
    if(ix>=0) name=name.substring(0, ix);
    VirtualMachine vm;
    getVM: {
      try {
      vm = VirtualMachine.attach(name);
      if(magic.equals(vm.getSystemProperties().getProperty("magic")))
        break getVM;
      } catch(Exception ex){}
 //   if the easy way failed, try iterating over all local JVMs
      for(VirtualMachineDescriptor vd:VirtualMachine.list()) try {
        vm=VirtualMachine.attach(vd);
        if(magic.equals(vm.getSystemProperties().getProperty("magic")))
          break getVM;
        vm.detach();
      } catch(Exception ex){}
 //   could not find our own JVM or could not attach to it
      return;
    }
    System.out.println("attached to: "+vm.id()+'/'+vm.provider().type());
    vm.loadAgent(createJar().getAbsolutePath());
    synchronized(SelfAttacher.class) {
      while(BACK_LINK==null) SelfAttacher.class.wait();
    }
    System.out.println("Now I have hands on instrumentation: "+BACK_LINK);
    System.out.println(BACK_LINK.isModifiableClass(SelfAttacher.class));
    vm.detach();
  }
 // create a JAR file for the agent; since our class is already in class path
 // our jar consisting of a MANIFEST declaring our class as agent only
  private static File createJar() throws IOException {
    File f=File.createTempFile("agent", ".jar");
    f.deleteOnExit();
    Charset cs=StandardCharsets.ISO_8859_1;
    try(FileOutputStream fos=new FileOutputStream(f);
        ZipOutputStream os=new ZipOutputStream(fos)) {
      os.putNextEntry(new ZipEntry("META-INF/MANIFEST.MF"));
      ByteBuffer bb = cs.encode("Agent-Class: "+SelfAttacher.class.getName());
      os.write(bb.array(), bb.arrayOffset()+bb.position(), bb.remaining());
      os.write(10);
      os.closeEntry();
    }
    return f;
  }
 // invoked when the agent is loaded into the JVM, pass inst back to the caller
  public static void agentmain(String agentArgs, Instrumentation inst) {
    synchronized(SelfAttacher.class) {
      BACK_LINK=inst;
      SelfAttacher.class.notifyAll();
    }
  }
}