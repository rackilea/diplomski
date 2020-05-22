PythonInterpreter py = new PythonInterpreter();
String dataFolder,prepFolder;
py.execfile("filename.py");
py.set("df", dataFolder);
py.set("pf", prepFolder);
py.exec("prep = Preprocess(df, pf)");

//if the preprocess method does not return anything, you can do:
py.exec("prep.preprocess()");

//To get the return value in java, you can do:
SomeJavaClass retvalue = py.eval("prep.preprocess()").__tojava__(SomeJavaClass.class);

//To get and store the return type in the python local namespace:
py.exec("retValue = prep.preprocess()");