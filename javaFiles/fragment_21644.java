JDefinedClass derived = codeModel._class(JMod.PUBLIC, "SomeClass", ClassType.CLASS);
    JClass keyType = codeModel.ref(String.class);
    JClass valueType = codeModel.ref(String.class);
    JClass mapClass = codeModel.ref(Map.class).narrow(keyType, valueType);
    JClass hashMapClass = codeModel.ref(HashMap.class).narrow(keyType, valueType);

    JMethod method = derived.method(JMod.PUBLIC, codeModel.VOID, "createHeaders");

    JBlock body = method.body();

    JVar headers = body.decl(mapClass, "headers", JExpr._new(hashMapClass));