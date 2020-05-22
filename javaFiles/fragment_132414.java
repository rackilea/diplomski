private class DefaultConstructorEmitter extends ClassEmitterTransformer {
        private final Signature CALL_SIGNATURE = TypeUtils.parseSignature("void someMethod(Object)");

        private String parametersKey;

        public DefaultConstructorEmitter(final String key) {
            parametersKey = key;
        }

        @Override
        public CodeEmitter begin_method(int access, Signature sig, Type[] exceptions) {
            final CodeEmitter emitter = super.begin_method(access, sig, exceptions);
            if (sig.getName().equals(Constants.CONSTRUCTOR_NAME)) {
                return new CodeEmitter(emitter) {
                    @Override
                    public void visitInsn(int arg0) {
                        if (arg0 == Opcodes.RETURN) {
                            Type classType = ...   
                            emitter.load_this();
                            emitter.push(parametersKey);
                            emitter.invoke_static(classType, CALL_SIGNATURE);
                        }
                        super.visitInsn(arg0);
                    }
                };
            }

            return emitter;
        }
    }