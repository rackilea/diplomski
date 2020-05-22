public class PersonConverter implements Converter {

    public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
        Person person = (Person) value;
        if(person.name != null){
            writer.setValue(person.name);
        } else if(person.address != null){
            for (Address address : person.address){
                writer.startNode("address");
                writer.setValue(address.street);
                writer.endNode();
            }
        }


    }

    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        Person person = new Person();
        person.name = reader.getValue();
        if(person.name.trim().length()==0){
            person.name = null;
        }
        List<Address> addresses = getAddress(reader, new ArrayList<Address>());
        person.address = addresses;
        if(person.address.size() == 0){
            person.address = null;
        }
        return person;
    }

    private List<Address> getAddress(HierarchicalStreamReader reader, List<Address> addresses){
        if (!reader.hasMoreChildren()){
            return addresses;
        }
        reader.moveDown();
        if(reader.getNodeName().equals("address")){
            addresses.add(new Address(reader.getValue()));
            reader.moveUp();
            getAddress(reader, addresses);
        }
        return addresses;
    }

    public boolean canConvert(Class clazz) {
        return clazz.equals(Person.class);
    }
}