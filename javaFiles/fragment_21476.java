public class Users implements Externalizable
{
    public Users(String userName,  String firstName, String lastName, String city, LocalDate birthday)
    {
        setUserName(userName);
        setFirstName(firstName);
        setBirthday(birthday);
    }

    private IntegerProperty userID = new SimpleIntegerProperty(this, "id");
    private StringProperty userName = new SimpleStringProperty(this, "userName');
    private ObjectProperty<LocalDate> birthday = new SimpleObjectProperty<>(this, "birthday");

    //Create setters and getters...

    @Override
    public void writeExternal(ObjectOutput out) throws IOException
    {
        out.writeInt(getUserID());
        out.writeObject(getUserName());
        out.writeObject(getBirthday());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
        setUserID((int) in.readInteger());
        setUserName((String) in.readObject());
        setBirthday((LocalDate) in.readObject());
    }
}