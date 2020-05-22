public class Child extends Parent {
    public String a;
    public String b;


    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        Child child = new Child();
        List<Field> fields = getFields(child.getClass());

        for(Field f: fields){
            f.setAccessible(true);
            f.set(child, "Test");
        }

        for(Field fd: fields){
            System.out.println(fd.get(child));
            fd.setAccessible(false);
        }


    }

    public static List<Field> getFields(Class<?> clazz){
        List<Field> list = new ArrayList<Field>();
        list.addAll(Arrays.asList(clazz.getDeclaredFields()));

        if(clazz.getSuperclass() != null){
            list.addAll(getFields(clazz.getSuperclass()));
        }
        return list;
    }
}