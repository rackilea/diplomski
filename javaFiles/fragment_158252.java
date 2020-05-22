@Aspect
public class EDTCheck {

    @Pointcut("call (* javax.swing..*+.*(..)) || " +
              "call (javax.swing..*+.new(..))")
    public void swingMethods() {}

    @Pointcut("call (* com.mystuff.swing..*+.*(..)) || " +
              "call (com.mystuff.swing..*+.new(..))")
    public void mySwingMethods() {}


    @Pointcut("call (* javax.swing..*+.add*Listener(..)) || " +
              "call (* javax.swing..*+.remove*Listener(..)) || " +
              "call (void javax.swing.JComponent+.setText(java.lang.String))")
    public void safeMethods() {}

    @Before("(swingMethods() || mySwingMethods()) && !safeMethods()")
    public void checkCallingThread(JoinPoint.StaticPart thisJoinPointStatic) {
        if(!SwingUtilities.isDispatchThread()) {
            System.out.println(
                    "Swing single thread rule violation: " 
                    + thisJoinPointStatic);
            Thread.dumpStack();
            // or you might throw an unchecked exception
        }
    }

}