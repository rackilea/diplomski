public class ReflectionNewInstanceTest {

    static class Animal {
        String name;
    }

    static class Cat extends Animal { 
        boolean hasTail = true;
    }

    public static void main(String[] args) throws Exception {
        Animal a = createAnimal(Cat.class);
    }


    static <T extends Animal> T createAnimal(Class<T> clazz) throws Exception {
        return clazz.newInstance();
    }

}