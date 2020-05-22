public void init() {
        interp = new PythonInterpreter(null, new PySystemState());

        PySystemState sys = Py.getSystemState();
        sys.path.append(new PyString(rootPath));
        sys.path.append(new PyString(modulesDir));
    }