public class ModelClass implements Model{

    private int id;

    public ModelClass(int id) {
        this.id = id;
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException{
        ois.defaultReadObject();
        DeserializerMap.INSTANCE.getSerializableObserver( this.getClass() ).
                onAfterDeserialization( this );
    }
}