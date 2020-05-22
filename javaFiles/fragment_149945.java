@Service
public class UserService {

    private List<UserData> data;

    public UserService() {
        this.data = new ArrayList<UserData>();
        this.data.add(new UserData(1, "Leanne Graham", "bret", "Sincere@april.biz", "Romaguera-Crona", "hildegard.org",
                "1-770-736-8031 x56442"));
        this.data.add(new UserData(2, "Ervin Howell", "Antonette", "Shanna@melissa.tv", "Deckow-Crist", "anastasia.net",
                "010-692-6593 x09125"));
        this.data.add(new UserData(3, "Clementine Bauch", "Samantha", "Nathan@yesenia.net", "Romaguera-Jacobson",
                "ramiro.info", "1-463-123-4447"));
        this.data.add(new UserData(4, "Patricia Lebsack", "Karianne", "Julianne.OConner@kory.org", "Robel-Corkery",
                "kale.biz", "1-770-736-8037"));
        this.data.add(new UserData(5, "Chelsey Dietrich", "Kamren", "Lucio_Hettinger@annie.ca", "Keebler LLC",
                "demarco.info", "1-344-736-8031 x564"));
    }

    /**
     * @return the data
     */
    public List<UserData> getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(List<UserData> data) {
        this.data = data;
    }

}