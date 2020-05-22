public class Injector {

 public static void main(String[] args) throws Throwable {
    CtClass cc = ClassPool.getDefault().get(Example.class.getName());
    CtConstructor staticConstructor = cc.getClassInitializer();
    if (staticConstructor != null) {
        CtConstructor staticConstructorClone = new CtConstructor(staticConstructor, cc, null);
        staticConstructorClone.getMethodInfo().setName("__NEW_NAME__");
        staticConstructorClone.setModifiers(Modifier.PUBLIC | Modifier.STATIC);
        cc.addConstructor(staticConstructorClone);

        // Here's the trick :-)

        staticConstructorClone.instrument(new ExprEditor() {

            @Override
            public void edit(FieldAccess f) throws CannotCompileException {
                try {
                    if (f.isStatic() && f.isWriter() && Modifier.isFinal(f.getField().getModifiers())) {
                        System.out.println("Found field");
                        f.replace("{  }");
                    }
                } catch (NotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        cc.writeFile("...);
    }
  }
}