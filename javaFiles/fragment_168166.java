Jep jep = new Jep();
jep.eval("import pickle");
jep.eval("clf = pickle.load(open('C:/Downloads/DSRFmodel.pkl', 'rb'))");
jep.eval("print(type(clf))");
Object randomForest = jep.getValue("clf", PyObject.class);

jep.eval("import integration");
jep.set("arg1", requestId);
jep.set("arg2", randomForest);
jep.eval("result = integration.trainmodel(arg1, arg2)");