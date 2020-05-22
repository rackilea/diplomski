String searchName="Hubert";
String searchRole="Admin";

UserJMXBean bean = new UserJMXBeanImpl();

for(User user : bean.getUserList()){
    if(user.getName().equals(searchName) && user.getRole().equals(searchRole)){
        //do something with your user
        String userID = user.getID();
    }
}