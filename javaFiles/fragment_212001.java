public class GetSignature {

    // the method for which you want to retrieve the signature
    Map<String, Map<?, ? super Integer>> someMethod() {
        return null;
    }

    public static void main(String[] args) throws Exception {
        // make the private method in class Method accessible
        Method methodGenericSignature = Method.class.getDeclaredMethod(
                "getGenericSignature",
                (Class<?>[]) null
        );
        methodGenericSignature.setAccessible(true);

        // get the signature from the method
        Method method = GetSignature.class.getDeclaredMethod("someMethod",
                (Class<?>[]) null
        );
        String returnValue = (String) methodGenericSignature.invoke(method,
                (Object[]) null
        );
        System.out.println("signature: " + returnValue);
    }
}