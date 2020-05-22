private List<User> getData() throws IOException{    
List<User> userList=new ArrayList<User>();
BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
for(int i=0;i<2;i++){
    System.out.println("Enter name,age:");
    String values=reader.readLine();
    String[] value=values.split(",");
    User user=new User();
    user.setName(value[0]);
    user.setAge(value[1]);
    userList.add(user);
}
return userList;
}