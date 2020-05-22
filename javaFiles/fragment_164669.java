List<Future<Boolean>> tasks = new ArrayList<>();
for (User user : userList) {
    SnmpPingDevice pingUser = new PingUser(user);
    tasks.add(executor.submit(pingUser));
}

for(Future<Boolean> task: tasks) {
    //use the result... OK to get() here.
}