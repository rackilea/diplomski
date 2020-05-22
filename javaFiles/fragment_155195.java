public class SelectiveList extends ArrayList<Object> {
    //the (types of) objects that we can store
    private ArrayList<Object> permittedObjects = new ArrayList<Object>();

    // put an Object type into the list
    public boolean addPermittedObject(Object o) {
        for (Object type : permittedObjects) {
            if (type.getClass() == o.getClass()) {
                return false; // if we already have it, do not add it again
            }
        }
        return permittedObjects.add(o); // else let's add it
    }

    // remove the Object type
    public boolean removePermittedObject(Object o) {
        for (Object type : permittedObjects) {
            if (type.getClass() == o.getClass()) {
                return permittedObjects.remove(type);
            }
        }
        return false;
    }

    @Override
    public boolean add(Object o) {
        for (Object type : permittedObjects) {
            if (type.getClass() == o.getClass()) {
                return super.add(o); // go ahead and add the item since it
                                        // matches our list
            }
        }
        return false;
    }
}