String[] sources = { "C:\\a\\TheMightyExampleProject\\src" };
String[] classPaths = { "C:\\a\\antlr-4.1-complete.jar" };

parser.setEnvironment(classPaths, sources, new String[] { "UTF-8" }, true);
parser.setBindingsRecovery(true);
parser.setResolveBindings(true);
parser.setCompilerOptions(options);
parser.setStatementsRecovery(true);
parser.setUnitName("C:\\a\\TheMightyExampleProject\\src"); // ftw