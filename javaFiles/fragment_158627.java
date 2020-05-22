static void generate() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 1024; i++) {
        sb.append(String.format("long checker%d = 0;%n", i));
    }
    sb.append("for (int i = 0; i < str.length(); ++i) {\n"
            + "int val = str.charAt(i);\n"
            + "int toCheck = val / 64;\n"
            + "val %= 64;\n"
            + "switch (toCheck) {\n");
    for (int i = 0; i < 1024; i++) {
        sb.append(String.format("case %d:\n"
                + "if ((checker%d & (1L << val)) > 0) {\n"
                + "return false;\n"
                + "}\n"
                + "checker%d |= (1L << val);\n"
                + "break;\n", i, i, i));
    }
    sb.append("}\n"
            + "}\n"
            + "return true;");
    System.out.println(sb);
}