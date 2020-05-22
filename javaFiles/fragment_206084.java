void doSomething(@WebParam(name="paramName") int param) {  }

Method method = Test.class.getDeclaredMethod("doSomething", int.class);
Annotation[][] annotations = method.getParameterAnnotations();

for (int i = 0; i < annotations.length; i ++) {
    for (Annotation annotation : annotations[i]) {
        System.out.println(annotation);
    }
}