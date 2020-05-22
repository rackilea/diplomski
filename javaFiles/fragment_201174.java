public class Test {

    public static void main(String[] args) {
        Example example = new Example();
        example.setName("Test");
        PropertyDescriptor descriptor = PropertyUtils.getPropertyDescriptorByName(example, "name");
        System.out.println((String) PropertyUtils.read(example, descriptor)); // Will call getName
    }

}
public class Example {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}