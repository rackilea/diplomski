1 for (int i = 0; i < users.length; i++) {
 2   if (username.equals(users[i])) {
 3     for (int a = 0; a < usersPassword.length; a++) {
 4       if (password.equals(usersPassword[i])) {
 5         System.out.println("You have successfully logged in!");
 6         status = "user";
 7         currentUserIndex = i;
 8         return;
 9       } else {
10         System.out.println("Wrong password");
11         return;
12       }
13     }
14   } else {
15     System.out.println("User not recognized");
16     return;
17   }
18 }