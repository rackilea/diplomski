new ExprEditor() {
        @Override
        public void edit(MethodCall m) throws CannotCompileException {
            try {
                if (m.where().getName().equals(sourceMethod)) {
                    if (m.getMethod().getName().equals(methodcalltoReplace)) {
                        if(lineNumberOfMethodcalltoReplace == m.getLineNumber()){
                            // The content of the hardcoded string can be replaced with runtime data
                            m.replace("$_ = ($r)"+"new com.nuwaza.aqua.sample.SampleForMethodInvocationFieldAccess().helloworld();");
                        }
                    }
                }
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
            super.edit(m);
        }