ConstructorSetup setup = new ConstructorSetup();
setup.setAppIconMimmapDirPathOnPc(Paths.get("/"));

// here we get actual class type of our Path object
Class classT = setup.getAppIconMimmapDirPathOnPc().getClass();

Gson gson = new GsonBuilder().registerTypeAdapter(classT, new MyPathConverter())