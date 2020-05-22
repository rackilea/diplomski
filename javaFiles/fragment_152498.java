public static void main(String[] args) throws ArgumentParserException {
    ArgumentParser parser = ArgumentParsers.newArgumentParser("prog");
    parser.addArgument("--foo").action(Arguments.storeTrue());
    parser.addArgument("--bar").action(Arguments.storeFalse());
    parser.addArgument("--baz").action(Arguments.storeFalse());
    System.out.println(parser.parseArgs(args));
}