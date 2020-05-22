public static void main(String[] args) {
    PropertySearcher ps = new PropertySearcher();
    for (Field f : ps.getClass().getDeclaredFields()) {

        for (Annotation a : f.getDeclaredAnnotations()) {
            if (a.annotationType().getName().equals(Target.class.getName())) {
                System.out.println("Fname= " + f.toGenericString());
                //do magic here
            }
        }
    }
}