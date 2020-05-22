GlobalEnvironment heap = new GlobalEnvironment();
IValueFactory vf = ValueFactoryFactory.getValueFactory();
TypeFactory TF = TypeFactory.getInstance();
IRascalMonitor mon = new NullRascalMonitor();
Evaluator eval = new Evaluator(vf, new PrintWriter(System.err), new PrintWriter(System.out), new ModuleEnvironment(ModuleEnvironment.SHELL_MODULE, heap), heap);


eval.doImport(mon, "demo::lang::Exp::Concrete::NoLayout::Syntax");
eval.doImport(mon, "ParseTree");
eval.eval(mon, "parse(#Exp, \"2+3\");", URIUtil.rootLocation("unknown"));