import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;
public static void main(String[] args)
{
    ClassPool cp = ClassPool.getDefault();
    CtClass ctClass = null;
    try {
        ctClass = cp.get(className);
    } catch (NotFoundException e) {
        throw new RuntimeException(e);
    }

    CtMethod ctMethod = ctClass.getMethod(methodName);

    ctMethod.instrument( 
           new ExprEditor() {
               public void edit(MethodCall calledMethod) {
                   System.out.println("Method "+ calledMethod.getMethod().getName() + " is called inside "+methodName);
           }
    });
}