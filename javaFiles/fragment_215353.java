import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class MethodDescriptionJ8 extends MethodDescription {
    @Override
    public String get(Method tellme) {
      Parameter param = tellme.getParameters()[0];
      return String.format("(java8) %s %s(%s %s){/*...*/}",
                    tellme.getReturnType(),
                    tellme.getName(),
                    param.getType(),
                    param.getName());
    }
}