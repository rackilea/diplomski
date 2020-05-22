public class ClassA {
    // Needed so that it can be replaced with setter
    private ClassB objB;

    // Extract the generation of ClassB so that it can be prevented
    public void generateClassB(String s1, String s2) {
        this.objB = new ClassB(s1, s2);
    }

    public void initMethod(String s1, String s2, String s3, String s4) {

        objB = null;
        if (s3 != null && s4 != null && s2 != null) {

            SampleUtil.KeyStorePasswordPair pair = SampleUtil.getKeyStorePasswordPair(s3, s4);

            generateClassB(s1, s2);

            try {
                objB.meth1();  //Note: meth1 and meth2 are void methods.
                objB.meth2();  // These two methods only to be accessed. something like doNothing

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setClassB(ClassB classB) {
        this.objB = classB;
    }
}