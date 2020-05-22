public class YourNiceAdapter
        extends XmlAdapter<ReceiverPerson,Person>{

    @Override public Person unmarshal(ReceiverPerson v){
        return v;
    }
    @Override public ReceiverPerson marshal(Person v){
        return new ReceiverPerson(v); // you must provide such c-tor
    }
}