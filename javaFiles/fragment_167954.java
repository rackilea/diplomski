final int NUM_USERS = 6;                     // Max Number of Users.
UserInfo[] users = new UserInfo[NUM_USERS];  // Array of Users.
int loginCounter = 0;                        // Counts bad login attempts.
int i = 0;                                   // Loop index variable.
String userRole = "";                        // Holds user's role text.
OUTER:
for (loginCounter = 1; loginCounter <= 3; ++loginCounter) {
        // Get User's Credentials.
        System.out.println("Enter Username: ");
        String username = input.next().toLowerCase();
        input.nextLine();                      // Allows User to enter password.
        System.out.println("Enter Password: ");
        String password = input.nextLine();

        // Convert password to MD5 hash.
        String hash = sysLogin.convertToMd5(password);
        for (i = 0; i < users.length; ++i) {
            if (username.equals(users[i].getUsername())) {
                if (hash.equals(users[i].getHash())) {
                    userRole = users[i].getRole();
                    sysLogin.goodLogin();      // Prints Good Login message.
                    break OUTER;
                }
            else {
                sysLogin.badLogin();           // Prints Bad Login message.
            }
            }
        }
    }