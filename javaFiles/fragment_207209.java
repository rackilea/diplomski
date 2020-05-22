ArrayList<userOnline> online = new ArrayList<>();
userOnline newUser = new userOnline();
newUser.userName = "MyUsername";
online.add(newUser);
System.out.println(online.size());
Iterator<userOnline> it = online.iterator();
while (it.hasNext()) {
    userOnline user = it.next();
    if ("MyUsername".equals(user.userName)) {
        it.remove();
    }
}
System.out.println(online.size());