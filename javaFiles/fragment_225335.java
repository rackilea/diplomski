Label lTryBlockStart = new Label();
Label lTryBlockEnd = new Label();
Label lCatchBlockStart = new Label();
Label lCatchBlockEnd = new Label();
// set up try-catch block for RuntimeException
mv.visitTryCatchBlock(lTryBlockStart, lTryBlockEnd, lCatchBlockStart, "java/lang/RuntimeException");
mv.visitLabel(lTryBlockStart);
// code to call the method goes here
mv.visitLabel(lTryBlockEnd);
mv.visitJumpInsn(GOTO, lCatchBlockEnd); // when here, no exception was thrown, so skip exception handler

// exception handler starts here, with RuntimeException stored on the stack
mv.visitLabel(lCatchBlockStart);
mv.visitVarInsn(ASTORE, 1); // store the RuntimeException in local variable 1
// here we could for example do e.printStackTrace()
mv.visitVarInsn(ALOAD, 1); // load it
mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/RuntimeException", "printStackTrace", "()V");

// exception handler ends here:
mv.visitLabel(lCatchBlockEnd);