Processor saxon = new Processor(false);
saxon.registerExtensionFunction(new MyExtension());

XQueryCompiler compiler = saxon.newXQueryCompiler();
XQueryExecutable exec = compiler.compile(new File("input/names.xq"));
XQueryEvaluator query = exec.load();

DocumentBuilder builder = saxon.newDocumentBuilder();
String students = "<xml>...</xml>";
Source src = new StreamSource(new StringReader(students));
XdmNode doc = builder.build(src);
query.setExternalVariable(new QName("student_list"), doc);

XdmValue result = query.evaluate();