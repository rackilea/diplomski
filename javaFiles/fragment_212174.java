for (CtMethod testmethod : methods) {
        if (testmethod.getName().startsWith("test")) {
            try {
                testmethod.instrument(
                    new ExprEditor() {
                        public void edit(Handler m)
                                throws CannotCompileException
                        {
                            m.insertBefore("throw $1;");
                        }
                    }
                );
                testmethod.insertBefore("semanticrt.statedump.dumpObjectState.setDumpTestCase(\""+testClassName+ "." + testmethod.getName()+"\");");
                CtClass etype = null;
                try {
                    etype = pool.get("java.lang.Exception");
                } catch (NotFoundException e) {
                    e.printStackTrace();
                }
                // See addCatch() https://jboss-javassist.github.io/javassist/tutorial/tutorial2.html
                String exceptionCode = "{ semanticrt.statedump.dumpObjectState.dumpExceptionToFile($e, " +
                        "\"" + outputFileRoot + "."+ testmethod.getName() + ".exception\", false); return; }\n";
                testmethod.addCatch(exceptionCode, etype);
            } catch (CannotCompileException e) {
                System.out.println(testmethod);
                e.printStackTrace();
            }
        }
    }