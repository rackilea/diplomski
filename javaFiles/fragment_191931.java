Exception in thread "main" java.lang.VerifyError: Operand stack overflow
Exception Details:
  Location:
    Test.<init>()V @4: ldc
  Reason:
    Exceeded max stack size.
  Current Frame:
    bci: @4
    flags: { flagThisUninit }
    locals: { uninitializedThis }
    stack: { uninitializedThis, 'java/io/PrintStream' }
  Bytecode:
    0000000: 2ab2 0002 1203 b600 04b1

        at java.lang.Class.getDeclaredMethods0(Native Method)
        at java.lang.Class.privateGetDeclaredMethods(Unknown Source)
        at java.lang.Class.getMethod0(Unknown Source)
        at java.lang.Class.getMethod(Unknown Source)
        at sun.launcher.LauncherHelper.validateMainClass(Unknown Source)
        at sun.launcher.LauncherHelper.checkAndLoadMain(Unknown Source)