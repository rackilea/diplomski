public class MailboxSystemSol{

    public static void main (String args[]) throws IOException{

        //define userlist, user and message variables..
        UserList userList = new UserList();
        User user = new User("Matthew", 1024);
        Message message = new Message("sender@gmail.com", "receiver@gmail.com", "Subject Content", "Body Content");

        //do something with declared variables...            

        writeAllToFile(userList, user, message);
    }

    public static void writeAllToFile(Userlist ul, User u, Message me){
        //code is too long to post here
    }

}