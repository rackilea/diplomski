public abstract class MyIdentityBaseClass implements IMyIdentityInterface {
    private String _id;
    private IMyIdentityInterface _parent;

    public MyIdentityBaseClass () {}

    @Override
    public String getId() {
        return _id;
    }

    @Override
    public void setId(String id) {
        _id = id;
    }

    @Override
    public IMyIdentityInterface getParent() {
        return _parent;
    }

    @Override
    public void setParent(IMyIdentityInterface parent) {
        _parent = parent;
        if (_id == null) {
            // if id isn't already set, set it to the generated id.
            _id = Helpers.makeIdFromParent(parent, getClass());
        }
    }

}