writer.writeFrameLabel(this.startLabel.target);
this.condition.writeInvJump(writer, this.endLabel.target);
this.action.writeStatement(writer);
writer.writeJumpInsn(Opcodes.GOTO, this.startLabel.target);

writer.writeFrameLabel(this.endLabel.target);