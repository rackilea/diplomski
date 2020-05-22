@Language("Java")
final String test = "class Test { "
        + "   private final String myProp = \"It works!\";"
        + ""
        + "   public void myMethod() {"
        + "      boolean i = false;"
        + "      "
        + "      if (i) {"
        + "        /* My comment */"
        + "      }"
        + "   }"
        + "}";