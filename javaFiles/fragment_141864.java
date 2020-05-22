public class User {

    private String mName;
    private String mId;
    private List<Pet> mPetList;

    public User(String id, String name) {
        this(id, name, Collections.<Pet>emptyList());
    }

    public User(String id, String name, List<Pet> pets) {
        mName = name;
        mId = id;
        mPetList = pets;
    }

    public String getName() {
        return mName;
    }

    public String getId() {
        return mId;
    }

    public User copyWithPets(List<Pet> pets) {
        return new User(mId, mName, pets);
    }

    @Override
    public String toString() {
        return "User{" +
                "mName='" + mName + '\'' +
                ", mId='" + mId + '\'' +
                ", mPetList=" + mPetList +
                '}';
    }
}