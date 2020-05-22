@Override
public void visitEnd() {
    // Iterates all instructions in the method
    ListIterator<AbstractInsnNode> itr = instructions.iterator();
    while (itr.hasNext()) {
        // Checks whether the instruction is ALOAD 1
        AbstractInsnNode node = itr.next();
        if (node.getOpcode() != Opcodes.ALOAD
                || ((VarInsnNode) node).var != 1)
            continue;

        // Checks whether the next instruction is INVOKEVIRTUAL
        if (node.getNext() == null
                || node.getNext().getOpcode() != Opcodes.INVOKEVIRTUAL)
            continue;

        // Checks the invoked method name and signature
        MethodInsnNode next = (MethodInsnNode) node.getNext();
        if (!next.owner.equals("Data")
                || !next.name.equals("check")
                || !next.desc.equals("()Z"))
            continue;

        // Checks whether the next of the next instruction is IFEQ
        AbstractInsnNode next2 = next.getNext();
        if (next2 == null
                || next2.getOpcode() != Opcodes.IFEQ)
            continue;

        // Creates a list instructions to be inserted
        InsnList list = new InsnList();
        list.add(new VarInsnNode(Opcodes.ALOAD, 1));
        list.add(new VarInsnNode(Opcodes.ALOAD, 2));
        list.add(new MethodInsnNode(Opcodes.INVOKESTATIC, 
            "Utilities", "someOtherCheck", 
            "(LData;LData;)Z", false));
        list.add(new JumpInsnNode(Opcodes.IFNE, ((JumpInsnNode) next2).label));

        // Inserts the list, updates maxStack to at least 2, and we are done
        instructions.insert(next2, list);
        maxStack = Math.max(2, maxStack);
        break;
    }
    accept(mv);
}