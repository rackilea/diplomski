Configuration conf = (Configuration) entry.getValue();
        String clazz = conf.getClazz();
           try {
        CtClass ctClass = ClassPool.getDefault().get(clazz);
        String appendCode = "{com.broada.bsp.gene.config.management.ConfigurationManager.manager.inject(this);\n}";
        CtConstructor constructor[] = ctClass.getDeclaredConstructors();

        for (CtConstructor ctConstructor : constructor) {
            ctConstructor.insertAfter(appendCode);
        }

            ctClass.toClass();