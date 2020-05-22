org.objectweb.asm.Label elseEnd = new org.objectweb.asm.Label();
// Condition
this.condition.writeInvJump(writer, elseStart);
this.then.writeStatement(writer);
writer.writeJumpInsn(Opcodes.GOTO, elseEnd);
writer.writeFrameLabel(elseStart);
this.elseThen.writeStatement(writer);
writer.writeFrameLabel(elseEnd);