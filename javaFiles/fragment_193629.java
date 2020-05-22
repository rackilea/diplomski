public class Main {
    public static void main(String[] args) {
        ContainerWrapper<Integer> containerWrapper = new ContainerWrapper<>(Integer.class);
        containerWrapper.add(1);
        System.out.println(containerWrapper.containerType());
        System.out.println(containerWrapper.isInteger());
    }
}

class ContainerWrapper<T> {
    // Store type information here
    private Class<T> clazz;
    private List<T> list = new ArrayList<>();

    public ContainerWrapper(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void add(T element) {
        list.add(element);
    }

    public Class<T> containerType() {
        return clazz;
    }

    public boolean isInteger() {
        return clazz.isAssignableFrom(Integer.class);
    }
}