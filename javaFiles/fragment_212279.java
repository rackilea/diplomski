public static void main(String[] args) throws Exception {
    final Method method = App.class.getMethod("myMethod");
    final int modifiers = method.getModifiers();
    System.out.println(modifiers);
    System.out.println(Integer.toBinaryString(modifiers));
}

public strictfp synchronized static final void myMethod() {

}