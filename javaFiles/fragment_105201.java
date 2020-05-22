// Not so sure what you want to do in this method... so you get to figure out that yourself!
public void userInternalDatabase (UserInfo info) {

    this.user = info.user;
    this.pass = info.pass;
    this.secretCode = info.secretCode;
}

public void addUser(String i, String j, String k) {
    UserInfo newUser = new UserInfo();
    newUser.user = i;
    newUser.pass = j;
    newUser.secretCode = k;
    InfoList.add(newUser);
}

public Object findUsername(String a)  
{    
    for (int i=0; i <InfoList.size(); i++) {
        if (InfoList.get(i).user.equals(a)){
             return "This user already exists in our database.";
        }
    }
    return "User is not founded."; // no Customer found with this ID; maybe throw an exception
}