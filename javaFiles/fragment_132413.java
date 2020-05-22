Enhancer enhancer = new Enhancer();
        enhancer.setNamingPolicy(new IndexedNamingPolicy());
        enhancer.setCallbackType(NoOp.class);
        enhancer.setUseCache(false);
        enhancer.setStrategy(new DefaultGeneratorStrategy() {
            @Override
            protected ClassGenerator transform(ClassGenerator cg) throws Exception {
                return new TransformingClassGenerator(cg, new DefaultConstructorEmitter(key));
            }
        });

        enhancer.setSuperclass(clazz);
        return enhancer.createClass();