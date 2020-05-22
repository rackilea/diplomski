public List<Object> doSomething(List<Object> objects) {
    for (int i = 0; i < objects.size(); i++) {
        Class<?> c = objects.get(i).getClass();
        for (Field field : c.getFields()) {
            if ("name".equals(field.getName())) {
                try {
                    System.out.println("class name " + c.getCanonicalName());// i get name my class
                    System.out.println(field.get(objects.get(i)));
                } catch (Exception e) {

                }
            }
        }
    }
    return null;
}