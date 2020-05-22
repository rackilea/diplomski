try (URLClassLoader cl = new URLClassLoader(urls.toArray(new URL[0])) {
        { byte[] code = gimmeLookupClassDef();
          defineClass("GimmeLookup", code, 0, code.length); }             }) {

        MethodHandles.Lookup lookup = (MethodHandles.Lookup)
            cl.loadClass("GimmeLookup").getField("lookup").get(null);
        Class<?> formatterClass =
            cl.loadClass("com.google.googlejavaformat.java.Formatter");

        Object formatInstance = formatterClass.getConstructor().newInstance();

        Method method = formatterClass.getMethod("formatSource", String.class);
        MethodHandle methodHandle = lookup.unreflect(method);
        MethodType type = methodHandle.type();
        MethodType factoryType =
            MethodType.methodType(FormatInvoker.class, type.parameterType(0));
        type = type.dropParameterTypes(0, 1);

        FormatInvoker formatInvoker = (FormatInvoker)
          LambdaMetafactory.metafactory(
                lookup, "invoke", factoryType, type, methodHandle, type)
            .getTarget().invoke(formatInstance);

      String text = (String) formatInvoker.invoke(sourceText);
      System.out.println(text);
    }