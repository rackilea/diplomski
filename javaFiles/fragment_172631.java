class Demo{
    private void test() throws IOException, FileAlreadyExistsException{}

    public static void main(java.lang.String[] args) throws Exception {
        Method declaredMethod = Demo.class.getDeclaredMethod("test");
        Class<?>[] exceptionTypes = declaredMethod.getExceptionTypes();
        for (Class<?> exception: exceptionTypes){
            System.out.println(exception);
        }
    }
}