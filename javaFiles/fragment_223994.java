public class Method implements Comparable<Method>{
........
@Override
public int compareTo(Method o) {
    return this.methodName.compareTo(o.getMethodName());
}