public class Pet {
    private String mName;

    public Pet(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "mName='" + mName + '\'' +
                '}';
    }
}