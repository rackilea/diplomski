for(MethodNode mn: cn.methods) {
    if(!mn.name.equals("main")) continue;
    Analyzer<BasicValue> analyzer = new Analyzer<>(new BasicInterpreter());
    analyzer.analyze(cn.name, mn);
    int i = -1;
    for (Frame<BasicValue> frame: analyzer.getFrames()) {
        i++;
        if(frame == null) continue;
        int opcode = mn.instructions.get(i).getOpcode();
        if(opcode != Opcodes.ILOAD) continue;
        BasicValue stackValue = frame.getStack(0);
        System.out.print(stackValue + "|" + frame.getStack(1));
        System.out.print(" - " + opcode + "\n");
    }
}