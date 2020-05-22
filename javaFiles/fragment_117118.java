public class SharedData {
        public  static String LoginName;

        public static void setLoginName(String LoginName) {
            SharedData.LoginName = LoginName;
        }

        public static String getLoginName() {
            return LoginName;
        }
    }