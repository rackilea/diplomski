@Ignore
public class SimpleTests2 {

    @Ignore
    @Deprecated
    public static void main(String[] args) throws ParseException, ClassNotFoundException {
        System.out.println(numUnique(new double[]{1.0, 1.0, 2.0, 3.0, 4.0, 3.0}));
    }

    @SuppressWarnings("test")
    private static int numUnique(double[] list) throws ClassNotFoundException {
        int unique = 0;
        for (int i = 0; i < list.length; i++) {
            boolean existsBefore = false;
            for (int j = i - 1; j >= 0; j--) {
                if (list[i] == list[j]) {
                    existsBefore = true;
                    break;
                }
            }
            if(!existsBefore) {
                unique++;
            }
        }
        printAnnotationsFromStacktrace();
        return unique;
    }

    private static void printAnnotationsFromStacktrace() throws ClassNotFoundException {
        StackTraceElement[] stacktraces = Thread.currentThread().getStackTrace();
        for(StackTraceElement stackTraceElement : stacktraces) {
            Class<?> aClass = Class.forName(stackTraceElement.getClassName());
            System.out.println(aClass);
            printAnnotation("\t%s\n", aClass.getAnnotations());
            String methodName = stackTraceElement.getMethodName();
            Method[] methods = aClass.getMethods();
            for(Method method : methods) {
                if(method.getName().equals(methodName)) {
                    System.out.printf("\t%s\n", method);
                    printAnnotation("\t\t%s\n", method.getDeclaredAnnotations());
                }
            }
        }
    }

    private static void printAnnotation(String pattern, Annotation[] annotations) {
        for(Annotation annotation : annotations) {
            System.out.printf(pattern, annotation);
        }
    }
}