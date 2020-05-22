public class User {
            private String name,password;
            private User(){
            }
            public User(String name,String password){
                name = name;
                password = password;
            }
            public String getName() {
                return name;
            }
            public void setName(String name) {
                name = name;
            }
            public String getPassword() {
                return password;
            }
            public void setPassword(String password) {
                password = password;
            }
        }