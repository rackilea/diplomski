for (Method method : MyClass.class.getDeclaredMethods()) {
    System.out.println("Method: " + method);
    System.out.println("synthetic: " + method.isSynthetic());
    System.out.println("bridge: " + method.isBridge());
}

// 1
//Method: public java.lang.Long Main$MyClass.getId()
//synthetic: false
//bridge: false
// 2
//Method: public java.lang.Object Main$MyClass.getId()
//synthetic: true
//bridge: true