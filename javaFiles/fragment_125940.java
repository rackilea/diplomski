// a Class is handed in to create a new instance of with basic reflection

construct_and_add: if (clazz != null) {

    try {
        Object obj = clazz.newInstance();

    } catch (Exception e) {
        System.err.println("Error <" + e.getClass().getName()
            + "> in reflective instantiation: " + e.getMessage());

        break construct_and_add;
    }

    somewhereElse.add(obj);
}