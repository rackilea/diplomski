MethodSpec.Builder method = 
    MethodSpec.methodBuilder("onSharedPreferenceChangeListener")
              .addAnnotation(Override.class)
              .addModifiers(Modifier.PUBLIC, 
                            Modifier.FINAL)  
              .addParameter(ParameterSpec.builder(ClassName.get(SharedPreferences.class),
                                                                "sharedPreferences")
                                         .build())
              .addParameter(ParameterSpec.builder(ClassName.get(String.class), 
                                                  "key")
                                         .build())
              .addCode(" add the switch-statement here ...");

TypeSpec.Builder typeSpec = 
    TypeSpec.classBuilder("Dummy")
            .addModifiers(Modifier.PUBLIC)
            .addStatement("private final $T valueFloatListener = new $T() $L",
                          ClassName.get(OnSharedPreferenceChangeListener.class),
                          ClassName.get(OnSharedPreferenceChangeListener.class), 
                          TypeSpec.anonymousClassBuilder("")
                                  .addSuperinterface(ClassName.get(OnSharedPreferenceChangeListener.class))
                                  .addMethod(method.build())
                                  .build());