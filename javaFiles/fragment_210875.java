public class backup implements IBackup {

    @Autowired
    Name nameObj;   

    public void setNameObj(Name nameObj) {
        this.nameObj = nameObj;
    }

    public String read(String firstName, String lastName) {
        String Name = "My Name is " + firstName + " " + lastName + " and my nickName is "  + nameObj.getNickName();
        return Name;
    }
}