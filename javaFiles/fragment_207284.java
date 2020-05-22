for (int i = 0; i < strings.length; i++) {
    builder.dup();
    builder.iconst(i);
    builder.aconst(strings[i]);
    builder.invokestatic("LMyClass;", "decode", "(Ljava/lang/String;)Ljava/lang/String;", false);
    builder.astore(InstructionAdapter.OBJECT_TYPE);
}