@Deprecated
@Override
public void visitMethodInsn(int opcode, String owner, String name,
        String desc) {
    if (api >= Opcodes.ASM5) {
        super.visitMethodInsn(opcode, owner, name, desc);
        return;
    }
    instructions.add(new MethodInsnNode(opcode, owner, name, desc));
}

@Override
public void visitMethodInsn(int opcode, String owner, String name,
        String desc, boolean itf) {
    if (api < Opcodes.ASM5) {
        super.visitMethodInsn(opcode, owner, name, desc, itf);
        return;
    }
    instructions.add(new MethodInsnNode(opcode, owner, name, desc, itf));
}