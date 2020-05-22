@Repository
public class RepoImpl implements RepositiryClass {

    @Override
    public List<Domain> get() {
        List<Domain> dList = new ArrayList<>();
        Domain one = new Domain("testOne", "testTwo");
        Domain two = new Domain("testTwo", "TestOne");
        Domain three = new Domain("three", "three");

        dList.add(one);
        dList.add(two);
        dList.add(three);

        return dList;
    }
}