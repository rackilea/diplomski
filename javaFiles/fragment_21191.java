public static void signUser(User u) {
      if(!users.isEmpty()){
        for(User f: users) {
            if(u.name.equals(f.name)) {
                System.out.println("User already exists");
            }
            else {
                users.add(u);
                System.out.println("User signed");
            }
        }
      } else{
      users.add(u.name);
      }
     }