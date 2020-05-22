File root = new File("./build/classes");
URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] {
   root.toURI().toURL()
});
Class<?> loadedClass = Class.forName("events.Source", true,classLoader);

// JSON --> Java "Create the actual type"
Type listType = new DefaultParameterizedType(ArrayList.class, loadedClass);

Gson gson = new Gson();
ArrayList<loadedClass> resourcesList = gson.fromJson(jsonString, listType);