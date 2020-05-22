PythonInterpreter jython = new PythonInterpreter();
jython.set("out", new PyString());
jython.exec("out = ''");
jython.exec("out += 'Test1\\n'");
jython.exec("out += 'Test2\\n'");
System.out.println(jython.get("out").toString());