CompilationUnit code = JavaParser.parse(
        "class Test {\n" +
            "private static final String CONST = \"This is a constant\";\n" +
            "public static void main(String[] args) {\n" +
                "System.out.println(\"Hello: \" + CONST);" +
            "}\n" +
        "}"
);
System.out.println("BEFORE:");
System.out.println(code);

removeStrings(code);

System.out.println("AFTER:");
System.out.println(code);