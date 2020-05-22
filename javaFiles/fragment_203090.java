//Where Person is a data class that implements Serializable and contains your desired fields
public void saveData(HashMap<String, Person> people) {
    FileOutputStream f = new FileOutputStream(new File("people.txt"));
    ObjectOutputStream o = new ObjectOutputStream(f);
    o.writeObject(people);
    o.close();
    f.close();
}
public HashMap<String, Person> loadData() {
    FileInputStream fi = new FileInputStream(new File("people.txt"));
    ObjectInputStream oi = new ObjectInputStream(fi);
    HashMap<String, Person> data = (HashMap<String, Person>) oi.readObject();
    oi.close();
    fi.close();
    return data;
}