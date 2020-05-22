public class DAOClass {

    public DAOClass(){
        SerializableObserver serializableObserver = new SerializableObserver() {
            @Override
            public void onAfterDeserialization(Object object) {
                System.out.println("After deserialization");
                anotherMethod();
            }
        };
        DeserializerMap.INSTANCE.registerSerializableObserver( ModelClass.class, serializableObserver );
    }

    public void anotherMethod(){
        System.out.println("another method");
    }
}