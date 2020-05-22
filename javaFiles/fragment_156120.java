class SoftReferenceMonitor extends ReferenceQueue<TestModel> {

    @Override
    public Reference<? extends TestModel> poll() {
        @SuppressWarnings("unchecked")
        Reference<TestModel> ref = (Reference<TestModel>) super.poll();
        if (ref != null) {
            int id = ((CustomizedSoftReference)ref).getId();
            TestSoftReference.map.remove(id);
            System.err.println("remove key/value '" + id + "' from map.");
        }
        return ref;
    }

}

class CustomizedSoftReference extends SoftReference<TestModel> {

    private int id;

    public int getId() {
        return id;
    }

    public CustomizedSoftReference(TestModel referent, ReferenceQueue<? super TestModel> q) {
        super(referent, q);
        this.id = referent.getNumber();
    }

}