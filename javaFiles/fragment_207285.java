for (int i = 0; i < strings.length; i++) {
    builder.dup();
    builder.iconst(i);
    builder.aconst(decode(strings[i]));
    builder.astore(InstructionAdapter.OBJECT_TYPE);
}