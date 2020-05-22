import org.aopalliance.intercept.MethodInvocation;

public class MethodInvocationExtractor<ArgumentType> {

    private MethodInvocation methodInvocation;

    public MethodInvocationExtractor(MethodInvocation methodInvocation) {
        this.methodInvocation = methodInvocation;
    }

    public ArgumentType getArg(int num) {
        try {
            Object[] arguments = methodInvocation.getArguments();
            return (ArgumentType) arguments[num];
        } catch (ClassCastException | ArrayIndexOutOfBoundsException e) {
            throw new IllegalStateException();
        }
    }
}