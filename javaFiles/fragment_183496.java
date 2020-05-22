Map<String, TibjmsAdmin> map = new HashMap<String, TibjmsAdmin>();
addAdmin(txtServer.getText(), txtUser.getText(), txtPassword.getText(), map);
_admin = new TibjmsAdmin[map.size()];
map.values().toArray(_admin);

QueueInfo[] info = _admin[0].getQueues(null);
for (int i = 0; i < info.length; i++) {
    String queueName = info[i].getName();
    if (!queueName.startsWith("$") && !queueName.startsWith(">")) {
        queues.add(queueName + ", 0");
    }
}