User u = new Info("Jack", 123);
UserInfo d1 = new UserInfo();
d1.addUser(u);

output v = new output(d1);

Print p = new Print();
p.addPrint(d1);

p.UserList();//Prints number of users
v.outputDetails();