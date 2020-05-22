public class BeanPersistence<T extends Bean> {

    public void printExtension(Bean bean) {
        System.out.println(bean.getExtension());
    }

    public static void main(String[] args) {

        BeanPersistence<Bean> persistence = new BeanPersistence<>();
        UserBean userBean = new UserBean();
        AdminBean adminBean = new AdminBean();
        persistence.printExtension(userBean); // prints u
        persistence.printExtension(adminBean); // prints a
    }
}

abstract class Bean {

    abstract String getExtension();
}

class UserBean extends Bean {

    private static final String FILE_EXT = "u";

    @Override
    String getExtension() {
        return FILE_EXT;
    }
}

class AdminBean extends Bean {

    private static final String FILE_EXT = "a";

    @Override
    String getExtension() {
        return FILE_EXT;
    }
}