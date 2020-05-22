Set<Class> classes = new HashSet<Class>();
classes.add(p.getClass());
for (A a : p.getThings()) {
    classes.add(a.getClass());
}
JAXBContext context = JAXBContext.newInstance(classes.toArray(new Class[classes.size()]));