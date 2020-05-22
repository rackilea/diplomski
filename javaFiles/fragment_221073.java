public class ANTLRDemo {
    public static void main(String[] args) throws Exception {
        String source =
                "namespace: ie.ondevice                             \n"+
                "{                                                  \n"+
                "    use: ie.ondevice.lang.Mixin;                   \n"+
                "    use: ie.ondevice.TraitsDeclaration;            \n"+
                "                                                   \n"+
                "    declare: Example < Mixin | TraitsDeclaration   \n"+
                "    {                                              \n"+
                "        include: \"path/to/file.extension\";       \n"+
                "        // implementation here                     \n"+
                "    }                                              \n"+
                "}                                                    ";
        ANTLRStringStream in = new ANTLRStringStream(source);
        CommonTokenStream tokens = new CommonTokenStream(new FJSLexer(in));
        FJSParser parser = new FJSParser(tokens);
        parser.parse();
        System.out.println(parser.obj);
    }
}