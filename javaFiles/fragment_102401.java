public class Main  {

public static void main(String[] args){
    HazelcastInstance hz = Hazelcast.newHazelcastInstance();
    IMap<String,Employees> map = hz.getMap("foo");
    map.put("1", new Employees());

    Employees employees = map.get("1");
    System.out.println(employees);
}

static class Employees extends ArrayList implements DataSerializable {
    @Override
    public void writeData(ObjectDataOutput out) throws IOException {
        out.writeInt(size());
        for(Object item: this){
            out.writeObject(item);
        }
    }

    @Override
    public void readData(ObjectDataInput in) throws IOException {
        int size = in.readInt();
        for(int k=0;k<size;k++){
            add(in.readObject());
        }
    }
}