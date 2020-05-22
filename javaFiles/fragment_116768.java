static MyClass func() {
   return new MyClass();
}

public static void main(String[] args) {
   func().setAttr(null); // change attributes
}