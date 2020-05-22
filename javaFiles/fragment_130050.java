public class MainActivity extends Activity {

    private UserInfo userInfo;

    public getCommonUserInfo() {
         if (userInfo == null) {
             userInfo = new UserInfo();
         }
         return userInfo;
    }

}