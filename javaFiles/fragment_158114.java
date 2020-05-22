public static void main(String[] args) throws PyException{
       Properties properties = new Properties();
       properties.setProperty("python.path", "/path/to/the/module/directory");
       PythonInterpreter.initialize(System.getProperties(), properties, new String[]{""});
       PythonInterpreter pi = new PythonInterpreter();
       pi.exec("from JythonTestModule import square");
       pi.set("integer", new PyInteger(42));
       pi.exec("result = square(integer)");
       pi.exec("print(result)");
       PyInteger result = (PyInteger)pi.get("result");
       System.out.println("result: "+ result.asInt());
       PyFunction pf = (PyFunction)pi.get("square");
       System.out.println(pf.__call__(new PyInteger(5)));
    }