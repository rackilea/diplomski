int register = ((access & Opcodes.ACC_STATIC) != 0) ? 0 : 1;
    lastParmReg = register - 1;
    List<String> sigs = parseSignature(desc); // my own method (see below*)
    for (String sig : sigs) {
        lastParmReg = register;
        register += ("J".equals(sig) || "D".equals(sig)) ? 2 : 1;
    }

    int myNewInjectedReg = register;
    register += isMyNewRegADoubleOrLong() ? 2 : 1;
    ....
    ....