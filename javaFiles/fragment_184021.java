public class UserModel {
    public static UserModel _instance;
    public String token;
    public Infos infos;

    public static UserModel getInstance() {
        if (_instance == null) {
            synchronized (UserModel.class) {
                if (_instance == null) {
                    _instance = new UserModel();
                    _instance.infos = new Infos();
                }
            }
        }
        return _instance;
    }

    public static class Infos {
       public String id;
       public String login;
    }
}