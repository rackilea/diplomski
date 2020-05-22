List<Person> persons = new ArrayList<Persons>();
// TODO fill persons.

ByteArrayOutputStream bao = new ByteArrayOutputStream();
ObjectOutputStream oos = new ObjectOutputStream(bao);
oos.writeObject(persons);
oos.close();

byte[] byteToTransfer = oos.getBytes();
// transfer