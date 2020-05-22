private static void analyze() throws IOException, AnalyzerException {
    ClassReader cr = new ClassReader(new FileInputStream(new File("input.class")));
    ClassNode cn = new ClassNode(Opcodes.ASM5);
    cr.accept(cn, 0);

    for(MethodNode mn: cn.methods) {
        if(!mn.name.equals("main")) continue;
        Analyzer<ConstantTracker.ConstantValue> analyzer
                = new Analyzer<>(new ConstantTracker());
        analyzer.analyze(cn.name, mn);
        int i = -1;
        for(Frame<ConstantTracker.ConstantValue> frame: analyzer.getFrames()) {
            i++;
            if(frame == null) continue;
            AbstractInsnNode n = mn.instructions.get(i);
            if(n.getOpcode() != Opcodes.ILOAD) continue;
            VarInsnNode vn = (VarInsnNode)n;
            System.out.println("accessing variable # "+vn.var);
            ConstantTracker.ConstantValue var = frame.getLocal(vn.var);
            System.out.println("\tcontains "+var);
        }
    }
}