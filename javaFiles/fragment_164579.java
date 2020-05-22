@Every("1h")
public class Bootstrap extends Job {

    public void doJob() {
        List<User> newUsers = User.find("newAccount = true").fetch();
        for(User user : newUsers) {
            Notifier.sayWelcome(user);
        }
    }

}