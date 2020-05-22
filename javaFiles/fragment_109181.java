User user = new User();
user.setId(1);
user.setName("stackover");

Message msg = new Message();
msg.setid(10);
msg.setmessage("hi");
msg.setUser(user);

HashMap<Integer, Message> map = new HashMap<>();                 
map.add(new Integer(msg.getId()), msg);

boolean isItInMapById = map.containsKey(new Integer(10));
boolean isItInMapByObject = map.containsValue(msg);