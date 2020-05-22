public class SmellyShoe {

    public static void main(String[] args) {
        try {
            java.lang.reflect.Constructor c = Shoe.class.getDeclaredConstructors()[0];
            c.setAccessible(true);
            Shoe smelly = (Shoe)c.newInstance(null);
            // grr
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}