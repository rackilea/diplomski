import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

public class App {
    public static void main(String[] args) throws NotFoundException {
        System.out.println("Get method line number with javassist\n");
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.quaternion.demo.Widget");
        CtMethod methodX = cc.getDeclaredMethod("x");
        int xlineNumber = methodX.getMethodInfo().getLineNumber(0);
        System.out.println("method x is on line " + xlineNumber + "\n");
    }
}