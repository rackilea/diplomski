import javassist.ClassPool;
import javassist.CtClass;

ClassPool pool = ClassPool.getDefault();
CtClass ctClass = pool.makeClass(new FileInputStream("pathTo\Test.class"));
System.out.println(ctClass);