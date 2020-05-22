public class SwingSafeMethodInvoker {

    public static InvokeLater invokeLater(Object obj, String methodName) {

        return new InvokeLater(obj, methodName);

    }

    public static InvokeLater invokeLater(Class clazz, String methodName) {

        return new InvokeLater(clazz, methodName);

    }

    public static InvokeAndWait invokeAndWait(Object obj, String methodName) {

        return new InvokeAndWait(obj, methodName);

    }

    public static InvokeAndWait invokeAndWait(Class clazz, String methodName) {

        return new InvokeAndWait(clazz, methodName);

    }

    public static InvokeAfter invokeAfter(Object obj, String methodName) {

        return new InvokeAfter(obj, methodName);

    }

    public static InvokeAfter invokeAfter(Class clazz, String methodName) {

        return new InvokeAfter(clazz, methodName);

    }

    public static InvokeAfterAndWait invokeAfterAndWait(Object obj, String methodName) {

        return new InvokeAfterAndWait(obj, methodName);

    }

    public static InvokeAfterAndWait invokeAfterAndWait(Class clazz, String methodName) {

        return new InvokeAfterAndWait(clazz, methodName);

    }

    public static MethodInvoker invoke(Object obj, String methodName) {

        return new MethodInvoker(obj, methodName);

    }

    public static MethodInvoker invoke(Class clazz, String methodName) {

        return new MethodInvoker(clazz, methodName);

    }

}