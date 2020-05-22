String input = "/**\n" +
        "\n" +
        "@Key1(\"value1\")\n" +
        "@Key2(\"value2\")\n" +
        "\n" +
        "*/\n" +
        "\n" +
        "This is the text that we need to skip. Only wanted to read the above commented section.\n" +
        "\n" +
        "//END_OF_FILE";

AnnotationLexer lexer = new AnnotationLexer(new ANTLRInputStream(input));
AnnotationParser parser = new AnnotationParser(new CommonTokenStream(lexer));
parser.parse();